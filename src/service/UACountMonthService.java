package service;

import java.util.List;

import vo.UACount;

import dao.UsualActivityDao;

public class UACountMonthService {
	private UsualActivityDao uad=new UsualActivityDao();
	
	
	

	public List<UACount> monthCount(String userID,int inOrOut, String beginTime, String endTime) throws Exception {
		// TODO Auto-generated method stub
		return uad.countGroupbyCatgID(userID,inOrOut, beginTime, endTime);
	}
	

	public List<UACount> monthRepaymentCount(String beginTime, String endTime) throws Exception {
		// TODO Auto-generated method stub
		return uad.repaymentCountGroupbyCatgID(beginTime, endTime);
	}

	public List<UACount> famMonthCount(int inOrOut, String beginTime, String endTime) throws Exception {
		// TODO Auto-generated method stub
		return uad.famCountGroupbyCatgID(inOrOut, beginTime, endTime);
	}
	
	public List<UACount> yearCount(String userID, int inOrOut,String beginTime, String endTime) throws Exception {
		// TODO Auto-generated method stub
		return uad.countGroupbyMonth(userID,inOrOut, beginTime, endTime);
	}
	
	public List<UACount> famYearCount(int inOrOut, String beginTime,String endTime) throws Exception {
		// TODO Auto-generated method stub
		return uad.famCountGroupbyMonth(inOrOut, beginTime, endTime);
	}
	
	
}