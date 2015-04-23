package action;

import java.sql.SQLException;
import java.util.List;

import model.Loan;
import model.Repayment;
import service.RepaymentService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RepaymentAction extends ActionSupport {
	
	private RepaymentService rs=new RepaymentService();
	private Repayment repayment;
	private Loan loan;
	private String msg="";
	private String loanID;
	private List<Repayment> repayments;
	private int totalCount;
	private int pageNum=1;
	private int type=0;
	/**
	 * 录入还款信息
	 * @throws SQLException 
	 * */
	public String add() throws SQLException{
		msg=rs.add(repayment);
		return msg;
	}
	
	/**
	 * 录入还款信息前
	 * */
	public String addInput(){
		setLoan(rs.addInput(repayment.getLoanID()));
		return "repaymentaddInput";
	}

	
	/**
	 * 查出所有还款款信息
	 * */
	public String list() throws Exception{
		if(repayment==null&&!("".equals(loanID))) {
			repayment=new Repayment();
			repayment.setLoanID(loanID);
		}
		this.setLoan(rs.loadLoanByID(repayment.getLoanID()));
		System.out.println(loan.getLoanID());
		this.setRepayments(rs.list(loan.getLoanID(),pageNum));
		System.out.println(repayments.size());
		this.setTotalCount(rs.totalCount(loan.getLoanID()));
		if(type==1) return "repaymentlist"+type;
		return "repaymentlist";
	}
	

	public RepaymentService getRs() {
		return rs;
	}

	public void setRs(RepaymentService rs) {
		this.rs = rs;
	}

	public Repayment getRepayment() {
		return repayment;
	}

	public void setRepayment(Repayment repayment) {
		this.repayment = repayment;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Repayment> getRepayments() {
		return repayments;
	}

	public void setRepayments(List<Repayment> repayments) {
		this.repayments = repayments;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoanID(String loanID) {
		this.loanID = loanID;
	}

	public String getLoanID() {
		return loanID;
	}


}