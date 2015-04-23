package model;

//Source file: D:\\study\\大学\\大四\\上学期\\毕业设计\\mine\\roseCode\\repayment.java


public class Repayment 
{
   private String repaymentID;
   private int periodNum;//第几期还款
   private double rMoney;//还款总和
   private String loanID;
   private double rCapital;//还款本金
   private double rInterest;//还款利息
   private double fineMoney;//还款罚款
   private String rTime;		//还款时间
   private String accountID;
   
   
public Repayment() {
	super();
	// TODO Auto-generated constructor stub
}
public Repayment(String repaymentID, int periodNum, double rMoney,
		String loanID, double rCapital, double rInterest, double fineMoney,
		String rTime, String accountID) {
	super();
	this.repaymentID = repaymentID;
	this.periodNum = periodNum;
	this.rMoney = rMoney;
	this.loanID = loanID;
	this.rCapital = rCapital;
	this.rInterest = rInterest;
	this.fineMoney = fineMoney;
	this.rTime = rTime;
	this.accountID = accountID;
}
public String getRepaymentID() {
	return repaymentID;
}
public void setRepaymentID(String repaymentID) {
	this.repaymentID = repaymentID;
}
public int getPeriodNum() {
	return periodNum;
}
public void setPeriodNum(int periodNum) {
	this.periodNum = periodNum;
}
public double getRMoney() {
	return rMoney;
}
public void setRMoney(double rMoney) {
	this.rMoney = rMoney;
}
public String getLoanID() {
	return loanID;
}
public void setLoanID(String loanID) {
	this.loanID = loanID;
}
public double getRCapital() {
	return rCapital;
}
public void setRCapital(double rCapital) {
	this.rCapital = rCapital;
}
public double getRInterest() {
	return rInterest;
}
public void setRInterest(double rInterest) {
	this.rInterest = rInterest;
}
public double getFineMoney() {
	return fineMoney;
}
public void setFineMoney(double fineMoney) {
	this.fineMoney = fineMoney;
}
public void setFineMoney(String fineMoney) {
	System.out.println(fineMoney);
	this.fineMoney = Double.parseDouble(fineMoney);
}
public String getRTime() {
	return rTime;
}
public void setRTime(String rTime) {
	this.rTime = rTime;
}
public String getAccountID() {
	return accountID;
}
public void setAccountID(String accountID) {
	this.accountID = accountID;
}
   
}
