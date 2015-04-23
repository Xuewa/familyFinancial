package service;

import java.sql.SQLException;
import java.util.List;
import model.ItemCategory;
import model.Loan;
import dao.ItemCategoryDao;
import dao.LoanDao;

public class LoanService {
	LoanDao ld=new LoanDao();
	ItemCategoryDao icd=new ItemCategoryDao();
	/**
	 * 根据执行成功的条数，判断成功与否
	 * @param loan
	 * @return msg
	 * */
	public String add(Loan loan) {
		// TODO Auto-generated method stub
		if(ld.add(loan)>0) return "success";
		else return "failed";
	}

	/**
	 * 根据ID查出贷款信息
	 * @return loan
	 * */
	public Loan updateInput(String loanID) throws Exception {
		// TODO Auto-generated method stub
		return ld.loadById(loanID);
	}
	
	public ItemCategory getParentIC(Loan loan) throws SQLException {
		// TODO Auto-generated method stub
		return icd.getParentICBycatgID(loan.getCatgID());
	}
	
	/**
	 * 查出所有用户信息
	 * @param pageNum 
	 * @return users
	 * */
	public List<Loan> list(int pageNum) throws Exception {
		// TODO Auto-generated method stub
		int start=(pageNum-1)*10+1;
		int end=pageNum*10;
		return ld.list(start,end);
	}

	public int totalCount() {
		// TODO Auto-generated method stub
		return ld.totalCount();
	}

	public String delete(Loan loan) {
		// TODO Auto-generated method stub
		return ld.deleteById(loan.getLoanID())>0?"success":"failed";
	}
	
	/**
	 * 修改贷款信息
	 * @return msg
	 * */
	public String update(Loan loan) throws Exception{
		return ld.update(loan)>0?"success":"failed";
	}
	
	
	
	public Loan updateInput(Loan loan){
		return ld.loadById(loan.getLoanID());
	}
	

	
}
