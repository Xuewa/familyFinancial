package model;


public class Loan 
{
   private String loanID;
   private String accountID;
   private double lMoney;//本金+利息和
   private double capital;//本金
   private double periodInterest;//每期利息
   private String lTime;
   private int lPeriod;
   /**
   每期还款的时间间隔：一搬为一个月，以月为单位
    */
   private int periodTime = 1;
   
   /**
   每期应还的金额
    */
   private double periodMoney;
   private String catgID;//用于哪个模块的借款（支出）
   private String note;//用途
   
   /**
    0:还款中；1:已经还清
    */
   private int status = 0;
   
   /**
   @roseuid 5504F892009A
    */
   public Loan() 
   {
    
   }

public Loan(String loanID,String accountID, double lMoney, double capital, double periodInterest,
		String lTime, int lPeriod, int periodTime,String catgID, double periodMoney,
		String note,  int status) {
	super();
	this.loanID = loanID;
	this.accountID=accountID;
	this.lMoney = lMoney;
	this.capital = capital;
	this.periodInterest = periodInterest;
	this.setLTime(lTime);
	this.lPeriod = lPeriod;
	this.periodTime = periodTime;
	this.catgID=catgID;
	this.periodMoney = periodMoney;
	this.note = note;
	this.status = status;
}

public String getLoanID() {
	return loanID;
}

public void setLoanID(String loanID) {
	this.loanID = loanID;
}

public double getLMoney() {
	return lMoney;
}

public void setLMoney(double lMoney) {
	this.lMoney = lMoney;
}

public double getCapital() {
	return capital;
}

public void setCapital(double capital) {
	this.capital = capital;
}

public int getLPeriod() {
	return lPeriod;
}

public void setLPeriod(int lPeriod) {
	this.lPeriod = lPeriod;
}

public int getPeriodTime() {
	return periodTime;
}

public void setPeriodTime(int periodTime) {
	this.periodTime = periodTime;
}

public double getPeriodMoney() {
	return periodMoney;
}

public void setPeriodMoney(double periodMoney) {
	this.periodMoney = periodMoney;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public void setLTime(String lTime) {
	this.lTime = lTime;
}

public String getLTime() {
	return lTime;
}

public void setPeriodInterest(double periodInterest) {
	this.periodInterest = periodInterest;
}

public double getPeriodInterest() {
	return periodInterest;
}

public void setAccountID(String accountID) {
	this.accountID = accountID;
}

public String getAccountID() {
	return accountID;
}

public void setCatgID(String catgID) {
	this.catgID = catgID;
}

public String getCatgID() {
	return catgID;
}
   
}
