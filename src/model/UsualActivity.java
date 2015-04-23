package model;
import java.sql.Date;

//Source file: D:\\study\\大学\\大四\\上学期\\毕业设计\\mine\\roseCode\\UsualActivity.java


public class UsualActivity 
{
   private String usualActivityID;
   private double money = 0;
    
   private String userID;
   private int inOrOut = 0;
   private String accountID;
   private String catgID;
   private String time;
   
   /**
   备注
    */
   private String note;
   
   /**
   @roseuid 5504F89101F1
    */
   public UsualActivity() 
   {}


public UsualActivity(String usualActivityID, double money, String userID,
		int inOrOut, String accountID, String catgID, String time, String note) {
	super();
	this.usualActivityID = usualActivityID;
	this.money = money;
	this.userID = userID;
	this.inOrOut = inOrOut;
	this.accountID = accountID;
	this.catgID = catgID;
	this.time = time;
	this.note = note;
}

public String getUsualActivityID() {
	return usualActivityID;
}

public void setUsualActivityID(String usualActivityID) {
	this.usualActivityID = usualActivityID;
}

public double getMoney() {
	return money;
}

public void setMoney(double money) {
	this.money = money;
}

public String getUserID() {
	return userID;
}

public void setUserID(String userID) {
	this.userID = userID;
}

public int getInOrOut() {
	return inOrOut;
}

public void setInOrOut(int inOrOut) {
	this.inOrOut = inOrOut;
}

public String getAccountID() {
	return accountID;
}

public void setAccountID(String accountID) {
	this.accountID = accountID;
}

public String getCatgID() {
	return catgID;
}

public void setCatgID(String catgID) {
	this.catgID = catgID;
}

public String getTime() {
	return time;
}

public void setTime(String time) {
	this.time = time;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}

}
