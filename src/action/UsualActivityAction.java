package action;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import model.ItemCategory;
import model.UsualActivity;
import service.UsualActivityService;

@SuppressWarnings("serial")
public class UsualActivityAction extends ActionSupport {
	
	private UsualActivityService uas=new UsualActivityService();
	private UsualActivity ua;
	private UsualActivity ua2;
	private ItemCategory pic;
	private String msg="";
	private List<UsualActivity> uass;
	private int type=0;//调用方式，0：非ajax，1：ajax
	private String userID;
	private String beginTime;
	private String endTime;
	private int totalCount=0;
	private int pageNum=1;
	
	/**
	 *用户记账 
	 **/
	public String add(){
		System.out.println(userID);
		ua.setUserID(userID);
		msg=uas.add(ua);
		return msg;
	}
	
	/**
	 *用户查看自己的所有日常收支 
	 * @throws Exception 
	 **/
	public String list() throws Exception{
		System.out.println(msg);
		if(getType()==1&&!"".equals(userID)) {
//			user=new User();
//			user.setUserID(userID);
			//System.out.println("beginTime:"+beginTime);
			//System.out.println("endTime:"+endTime);
			this.setUass(uas.list(userID,beginTime,endTime,pageNum));
			this.setTotalCount(uas.totalCount(userID,beginTime,endTime));
			System.out.println("totalCount:"+totalCount);
			return "usualActivitylist"+type;
		}
		
		if(beginTime==null) {
			Date today=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			beginTime=sdf.format(today)+" 00:00";
			endTime=sdf.format(today)+" 23:59";
		}
//		System.out.println("userID:"+user.getUserID());
		this.setUass(uas.list(userID,beginTime,endTime,pageNum));
		this.setTotalCount(uas.totalCount(userID,beginTime,endTime));
		//System.out.println("totalCount:"+totalCount);
		return "usualActivitylist";
	}
	
	/**
	 * 修改收支类别信息后
	 * */
	public String update() throws Exception{
		System.out.println(ua2);
		msg=uas.update(ua,ua2);
		return msg;
	}
	
	/**
	 * 修改收支记录信息
	 * @throws SQLException 
	 * */
	public String updateInput() throws SQLException{
		setUa(uas.updateInput(ua));
		setPic(uas.getParentIC(ua));
		return "updateInputUA"+type;
	}
	
	/**
	 * 删除日常收支
	 * */
	public String delete(){
		msg=uas.delete(ua);
		return msg;
	}
	
	
	

	public UsualActivityService getUas() {
		return uas;
	}

	public void setUas(UsualActivityService uas) {
		this.uas = uas;
	}

	public UsualActivity getUa() {
		return ua;
	}

	public void setUa(UsualActivity ua) {
		this.ua = ua;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<UsualActivity> getUass() {
		return uass;
	}

	public void setUass(List<UsualActivity> uass) {
		this.uass = uass;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setPic(ItemCategory pic) {
		this.pic = pic;
	}

	public ItemCategory getPic() {
		return pic;
	}

	public void setUa2(UsualActivity ua2) {
		this.ua2 = ua2;
	}

	public UsualActivity getUa2() {
		return ua2;
	}


}
