package action;

import java.util.List;

import model.ItemCategory;
import model.Loan;
import service.LoanService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoanAction extends ActionSupport {
	
	private LoanService ls=new LoanService();
	private Loan loan;
	private String msg="";
	private List<Loan> loans;
	private int totalCount;
	private int pageNum=1;
	private int type=0;
	private ItemCategory pic;
	/**
	 * 录入贷款信息
	 * */
	public String add(){
		loan.setLMoney(loan.getLPeriod()*loan.getPeriodMoney());
		msg=ls.add(loan);
		return msg;
	}

	/**
	 * 查出某个贷款信息
	 * */
	public String updateInput() throws Exception{
		this.setLoan(ls.updateInput(loan.getLoanID()));
		this.setPic(ls.getParentIC(loan));
		return "updateInputLoan0";
	}
	
	/**
	 * 更新未开始还款的贷款信息
	 * */
	public String update() throws Exception{
		loan.setLMoney(loan.getLPeriod()*loan.getPeriodMoney());
		return ls.update(loan);
	}
	
	/**
	 * 查出所有贷款信息
	 * */
	public String list() throws Exception{
		//System.out.println(pageNum);
		this.setLoans(ls.list(pageNum));
		this.setTotalCount(ls.totalCount());
		if(type==1) return "loanlist"+type;
		return "loanlist";
	}
	
	/**
	 * 删除未开始还款的贷款
	 * */
	public String delete(){
//		System.out.println(user.getUserID());
		msg=ls.delete(loan);
		return msg;
	}
	
//	/**
//	 * 删除未开始还款的贷款
//	 * */
//	public String payback(){
////		System.out.println(user.getUserID());
//		msg=ls.payback(loan);
//		return msg;


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LoanService getLs() {
		return ls;
	}

	public void setLs(LoanService ls) {
		this.ls = ls;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public void setPic(ItemCategory pic) {
		this.pic = pic;
	}

	public ItemCategory getPic() {
		return pic;
	}

}