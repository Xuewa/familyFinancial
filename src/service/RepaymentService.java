package service;

import java.sql.SQLException;
import java.util.List;
import model.Loan;
import model.Repayment;
import model.UsualActivity;
import dao.AccountDao;
import dao.LoanDao;
import dao.RepaymentDao;

public class RepaymentService {
	RepaymentDao rd=new RepaymentDao();
	LoanDao ld=new LoanDao();
	AccountDao ad=new AccountDao();
	/**
	 * 根据执行成功的条数，判断成功与否
	 * @param repayment
	 * @return msg
	 * @throws SQLException 
	 * */
	public String add(Repayment repayment) throws SQLException {
		// TODO Auto-generated method stub
		int flag=0;
		UsualActivity ua=new UsualActivity();
		ua.setAccountID(repayment.getAccountID());
		ua.setInOrOut(1);
		ua.setMoney(repayment.getRMoney());
		flag+=ad.updateTMoney(ua);
		if(flag==0) return "failed";
		Repayment repayment2=rd.add(repayment);
		Loan loan=ld.loadById(repayment2.getLoanID());
		if(repayment2.getPeriodNum()==1) loan.setStatus(1);
		if(repayment2.getPeriodNum()==loan.getLPeriod()) loan.setStatus(2);
		flag=0;
		flag+=ld.changeStatus(loan);
		if(flag==0) return "failed";
		return "success";
	}

	
	
	/**
	 * 查出所有用户信息
	 * @param pageNum 
	 * @return users
	 * */
	public List<Repayment> list(String loanID,int pageNum) throws Exception {
		// TODO Auto-generated method stub
		int start=(pageNum-1)*10+1;
		int end=pageNum*10;
		return rd.list(loanID,start,end);
	}

	public int totalCount(String loanID) {
		// TODO Auto-generated method stub
		return rd.totalCount(loanID);
	}



	public Loan loadLoanByID(String loanID) {
		// TODO Auto-generated method stub
		return ld.loadById(loanID);
	}



	public Loan addInput(String loanID) {
		// TODO Auto-generated method stub
		return ld.loadById(loanID);
	}

	
	
	

	
}
