package service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import dao.AccountDao;
import dao.ItemCategoryDao;
import dao.UsualActivityDao;
import model.ItemCategory;
import model.UsualActivity;

public class UsualActivityService {

	private UsualActivityDao uad=new UsualActivityDao();
	private ItemCategoryDao icd=new ItemCategoryDao();
	private AccountDao ad=new AccountDao();
	
	public String add(UsualActivity ua) {
		// TODO Auto-generated method stub
		int flag=0;
		//修改account的余额
		flag+=ad.updateTMoney(ua); //1:成功；2:失败
		if(flag==2) return "failed";
		//记账
		return uad.add(ua)>0?"success":"failed";
	}


	public List<UsualActivity> list(String userID, String beginTime, String endTime,int pageNum) throws Exception {
		// TODO Auto-generated method stub
		int start=(pageNum-1)*10+1;
		int end=pageNum*10;
		return uad.list(userID,beginTime,endTime,start,end);
	}


	public int totalCount(String userID, String beginTime, String endTime) throws Exception {
		// TODO Auto-generated method stub
		return uad.totalCount(userID,beginTime,endTime);
	}


	public String delete(UsualActivity ua) {
		return uad.delete(ua)>0?"success":"failed";
	}


	public UsualActivity updateInput(UsualActivity ua) throws SQLException {
		// TODO Auto-generated method stub
		return uad.loadByID(ua.getUsualActivityID());
	}
	
	public ItemCategory getParentIC(UsualActivity ua) throws SQLException {
		// TODO Auto-generated method stub
		return icd.getParentICBycatgID(ua.getCatgID());
	}


	public String update(UsualActivity ua, UsualActivity ua2) throws SQLException {
		// TODO Auto-generated method stub
		int flag=0;
		//修改账户或金额有所修改 
		System.out.println(ua.getAccountID());
		System.out.println(ua2.getAccountID());
		System.out.println(ua.getMoney());
		System.out.println(ua2.getMoney());
		if((!ua.getAccountID().equals(ua2.getAccountID()))||(ua.getMoney()!=ua2.getMoney())) 
		{
			//还原旧账户余额
			if(ua.getInOrOut()==0) {
				ua.setInOrOut(1);
				flag+=ad.updateTMoney(ua);//1:成功；2:失败
			}else if(ua.getInOrOut()==1) {
				ua.setInOrOut(0);
				flag+=ad.updateTMoney(ua);
			}
			//修改新账户余额
			flag=ad.updateTMoney(ua2);
			if(flag!=1) {System.out.println(flag+"==");return "failed";}
		}	
		//修改UA
		flag=0;
		String time=ua2.getTime().substring(0, 16);
		//SimpleDateFormat sdf=new SimpleDateFormat();
		System.out.println(time);
		ua2.setTime(time);
		flag+=uad.update(ua2);
		return flag>0?"success":"failed";
	}


}

