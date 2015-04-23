package model;

import java.sql.Date;

//Source file: D:\\study\\大学\\大四\\上学期\\毕业设计\\mine\\roseCode\\Household.java


public class Household extends FamMember 
{
	 private String userID;
	 private String userName;
	 private String password;
	 private String name;
	   
	   /**
	   0:男;1:女
	    */
	private int sex = 0;
	private Date birthday;
	private String mobile;
	private String id;
	private String relation;
	private int role = 0;
	private int status = 0;
	public Account theAccount[];
	public UsualActivity theUsualActivity[];
   public Budget theBudget[];
   public Repayment theRepayment[];
   public Loan theLoan[];
   
   /**
   @roseuid 5504F8920117
    */
   public Household() 
   {
    
   }
   
   public Household(Budget[] theBudget, Repayment[] theRepayment, Loan[] theLoan) {
	super();
	this.theBudget = theBudget;
	this.theRepayment = theRepayment;
	this.theLoan = theLoan;
}

/**
   @roseuid 55015B4B01B2
    */
   public void addBudget() 
   {
    
   }
   
   /**
   @roseuid 55015B6202A7
    */
   public void updateBudget() 
   {
    
   }
   
   /**
   @roseuid 55015B690337
    */
   public void deleteBudget() 
   {
    
   }
   
   /**
   @param loanID
   @param lMoney
   @param capital
   @param interest
   @param lTime
   @param lPeriod
   @param periodTime
   @param periodMoney
   @param note
   @param person
   @param status
   @roseuid 5502A37D033F
    */
   public void addLoan(String loanID, double lMoney, double capital, double interest, Date lTime, int lPeriod, int periodTime, double periodMoney, String note, User person, int status) 
   {
    
   }
   
   /**
   @param repaymentID
   @param rMoney
   @param loan
   @param rCapital
   @param rInterest
   @param rTime
   @param account
   @param person
   @param fineMoney
   @roseuid 5502A4CA0359
    */
   public void addRepayment(String repaymentID, double rMoney, Loan loan, double rCapital, double rInterest, Date rTime, Account account, User person, double fineMoney) 
   {
    
   }

public Budget[] getTheBudget() {
	return theBudget;
}

public void setTheBudget(Budget[] theBudget) {
	this.theBudget = theBudget;
}

public Repayment[] getTheRepayment() {
	return theRepayment;
}

public void setTheRepayment(Repayment[] theRepayment) {
	this.theRepayment = theRepayment;
}

public Loan[] getTheLoan() {
	return theLoan;
}

public void setTheLoan(Loan[] theLoan) {
	this.theLoan = theLoan;
}

public String getUserID() {
	return userID;
}

public void setUserID(String userID) {
	this.userID = userID;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getSex() {
	return sex;
}

public void setSex(int sex) {
	this.sex = sex;
}

public Date getBirthday() {
	return birthday;
}

public void setBirthday(Date birthday) {
	this.birthday = birthday;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getRelation() {
	return relation;
}

public void setRelation(String relation) {
	this.relation = relation;
}

public int getRole() {
	return role;
}

public void setRole(int role) {
	this.role = role;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public Account[] getTheAccount() {
	return theAccount;
}

public void setTheAccount(Account[] theAccount) {
	this.theAccount = theAccount;
}

public UsualActivity[] getTheUsualActivity() {
	return theUsualActivity;
}

public void setTheUsualActivity(UsualActivity[] theUsualActivity) {
	this.theUsualActivity = theUsualActivity;
}
   
}
