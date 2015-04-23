package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import service.UACountMonthService;
import vo.UACount;

public class UACountMonthAction {
	private UACount uac;
	private UACountMonthService uacs=new UACountMonthService();
	private int type=0;
	private String beginTime;
	private String endTime;
	private int role=0;
	private String userID;
	private int month;
	private List<Integer> years;
	private List<UACount> inUacss;//个人收入比例
	private List<UACount> outUacss;//个人支出比例
	private List<UACount> aUacss;
	private List<UACount> reUacss;//还款比例
	private List<UACount> finUacss;//全家收入比例
	private List<UACount> foutUacss;//全家支出比例
	private List<UACount> faUacss;
	private double insumTotal=0;
	private double outsumTotal=0;
	private double resumTotal=0;
	private double finsumTotal=0;
	private double foutsumTotal=0;
	public String monthCount() throws Exception{
		if (beginTime==null){
			Calendar cale = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			cale.add(Calendar.MONTH, 0);
			month=cale.get(Calendar.MONTH)+1;
			System.out.println("month:"+month);
			cale.set(Calendar.DAY_OF_MONTH, 1);
			beginTime = sdf.format(cale.getTime());
			cale.add(Calendar.MONTH, 1);
			cale.set(Calendar.DAY_OF_MONTH, 0);
			endTime = sdf.format(cale.getTime());
		}
		System.out.println("beginT:"+beginTime);
		System.out.println("endT:"+endTime);
		//个人
		setInUacss(uacs.monthCount(userID,0, beginTime, endTime));
		setOutUacss(uacs.monthCount(userID,1, beginTime, endTime));
		for(UACount uacc:inUacss) insumTotal+=uacc.getSumMoney();
		for(UACount uacc:outUacss) outsumTotal+=uacc.getSumMoney();
		if(role==2){
			//还款
			setReUacss(uacs.monthRepaymentCount(beginTime, endTime));
			//家庭统计
			setFinUacss(uacs.famMonthCount(0, beginTime, endTime));
			setFoutUacss(uacs.famMonthCount(1, beginTime, endTime));
			for(UACount uacc:reUacss) resumTotal+=uacc.getSumMoney();
			for(UACount uacc:finUacss) finsumTotal+=uacc.getSumMoney();
			for(UACount uacc:foutUacss) foutsumTotal+=uacc.getSumMoney();
		}
		
		
		//if(type==1) return "monthCount"+type;
		return "monthCount";
	}
	
	public String yearCount() throws Exception{
		Calendar cale = Calendar.getInstance();
		cale.add(Calendar.YEAR, 0);
		int year=cale.get(Calendar.YEAR);
		System.out.println("year:"+year);
		this.years=new ArrayList<Integer>();
		for(int i=2010;i<=year;i++) 
			years.add(i);
		if (type==0&&beginTime==null){
			beginTime = year+"-01-01";
			endTime = year+"-12-31";;
		}
		System.out.println("beginT:"+beginTime);
		System.out.println("endT:"+endTime);
		this.years=new ArrayList<Integer>();
		for(int i=2010;i<=year;i++) 
			years.add(i);
		setInUacss(uacs.yearCount(userID,0, beginTime, endTime));
		setOutUacss(uacs.yearCount(userID,1, beginTime, endTime));
		setFinUacss(uacs.famYearCount(0, beginTime, endTime));
		setFoutUacss(uacs.famYearCount(1, beginTime, endTime));
		aUacss=new ArrayList<UACount>();
		faUacss=new ArrayList<UACount>();
		for(UACount uacc:inUacss) insumTotal+=uacc.getSumMoney();
		for(UACount uacc:outUacss) outsumTotal+=uacc.getSumMoney();
		for(UACount uacc:finUacss) finsumTotal+=uacc.getSumMoney();
		for(UACount uacc:foutUacss) foutsumTotal+=uacc.getSumMoney();
		for(int i=1;i<=12;i++){
			double in=0,out=0;
			for(UACount uacc:inUacss) 
				if(Integer.parseInt(uacc.getColumn())==i) in=uacc.getSumMoney();
			for(UACount uacc:outUacss) 
				if(Integer.parseInt(uacc.getColumn())==i) out=uacc.getSumMoney();
			UACount auac=new UACount();
			auac.setColunm(Integer.toString(i));
			auac.setSumMoney(in-out);
			aUacss.add(auac);
			in=0;out=0;
			for(UACount uacc:finUacss) 
				if(Integer.parseInt(uacc.getColumn())==i) {
					in=uacc.getSumMoney();
					System.out.println(in);
				}
			for(UACount uacc:foutUacss) 
				if(Integer.parseInt(uacc.getColumn())==i) out=uacc.getSumMoney();
			UACount fauac=new UACount();
			fauac.setColunm(Integer.toString(i));
			fauac.setSumMoney(in-out);
			faUacss.add(fauac);
		}
		
		if(role==2){
			//还款
			//家庭统计
		}
		System.out.println(aUacss.size());
		return "yearCount";
	}
	
	
	public void setUac(UACount uac) {
		this.uac = uac;
	}

	public UACount getUac() {
		return uac;
	}

	public void setUacs(UACountMonthService uacs) {
		this.uacs = uacs;
	}

	public UACountMonthService getUacs() {
		return uacs;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}


	public String getBeginTime() {
		return beginTime;
	}


	public void setType(int type) {
		this.type = type;
	}


	public int getType() {
		return type;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getUserID() {
		return userID;
	}


	public void setMonth(int month) {
		this.month = month;
	}


	public int getMonth() {
		return month;
	}



	public void setYears(List<Integer> years) {
		this.years = years;
	}

	public List<Integer> getYears() {
		return years;
	}

	public void setOutUacss(List<UACount> outUacss) {
		this.outUacss = outUacss;
	}

	public List<UACount> getOutUacss() {
		return outUacss;
	}

	public List<UACount> getInUacss() {
		return inUacss;
	}

	public void setInUacss(List<UACount> inUacss) {
		this.inUacss = inUacss;
	}

	public double getInsumTotal() {
		return insumTotal;
	}

	public void setInsumTotal(double insumTotal) {
		this.insumTotal = insumTotal;
	}

	public double getOutsumTotal() {
		return outsumTotal;
	}

	public void setOutsumTotal(double outsumTotal) {
		this.outsumTotal = outsumTotal;
	}

	public void setAUacss(List<UACount> aUacss) {
		this.aUacss = aUacss;
	}

	public List<UACount> getAUacss() {
		return aUacss;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getRole() {
		return role;
	}

	public void setReUacss(List<UACount> reUacss) {
		this.reUacss = reUacss;
	}

	public List<UACount> getReUacss() {
		return reUacss;
	}

	public void setFinUacss(List<UACount> finUacss) {
		this.finUacss = finUacss;
	}

	public List<UACount> getFinUacss() {
		return finUacss;
	}

	public void setFoutUacss(List<UACount> foutUacss) {
		this.foutUacss = foutUacss;
	}

	public List<UACount> getFoutUacss() {
		return foutUacss;
	}

	public void setFinsumTotal(double finsumTotal) {
		this.finsumTotal = finsumTotal;
	}

	public double getFinsumTotal() {
		return finsumTotal;
	}

	public void setFoutsumTotal(double foutsumTotal) {
		this.foutsumTotal = foutsumTotal;
	}

	public double getFoutsumTotal() {
		return foutsumTotal;
	}

	public void setResumTotal(double resumTotal) {
		this.resumTotal = resumTotal;
	}

	public double getResumTotal() {
		return resumTotal;
	}

	public void setFaUacss(List<UACount> faUacss) {
		this.faUacss = faUacss;
	}

	public List<UACount> getFaUacss() {
		return faUacss;
	}


}
