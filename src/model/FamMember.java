package model;

import java.sql.Date;

//Source file: D:\\study\\大学\\大四\\上学期\\毕业设计\\mine\\roseCode\\FamMenber.java


public class FamMember extends User 
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
   
   /**
   @roseuid 5504F891024F
    */
   public FamMember() 
   {
    
   }
   
   
   
   public FamMember(String userID, String userName, String password, String name,
		int sex, Date birthday, String mobile, String id, String relation,
		int role, int status, Account[] theAccount,
		UsualActivity[] theUsualActivity) {
	super();
	this.userID = userID;
	this.userName = userName;
	this.password = password;
	this.name = name;
	this.sex = sex;
	this.birthday = birthday;
	this.mobile = mobile;
	this.id = id;
	this.relation = relation;
	this.role = role;
	this.status = status;
	this.theAccount = theAccount;
	this.theUsualActivity = theUsualActivity;
}



/**
   @param accountID
   @param type
   @param accountNum
   @param accountName
   @param tMoney
   @roseuid 54FF79C501C4
    */
   public void addAccount(String accountID, int type, String accountNum, String accountName, double tMoney) 
   {
    
   }
   
   /**
   @param accountID
   @roseuid 54FF7AAC0149
    */
   public void deleteAccount(String accountID) 
   {
    
   }
   
   /**
   @param usualActivityID
   @param uMoney
   @param person
   @param inOrOut
   @param account
   @param itemCategory
   @param time
   @param note
   @roseuid 5502A11503C4
    */
   public void addUsualActivity(String usualActivityID, double uMoney, User person, int inOrOut, Account account, ItemCategory itemCategory, Date time, String note) 
   {
    
   }
   
   /**
   @param uMoney
   @param person
   @param inOrOut
   @param account
   @param itemCategory
   @param time
   @param note
   @roseuid 5502A1D80056
    */
   public void updateUsualActivity(double uMoney, User person, int inOrOut, Account account, ItemCategory itemCategory, Date time, String note) 
   {
    
   }
   
   /**
   @param usualActivityID
   @roseuid 5502A2000201
    */
   public void deleteUsualActivity(String usualActivityID) 
   {
    
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
