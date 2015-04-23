package model;

import java.sql.Date;

//Source file: D:\\study\\大学\\大四\\上学期\\毕业设计\\mine\\roseCode\\Budget.java


public class Budget 
{
   private String budgetID;
   private double bMoney;
   
   /**
   限制大类的预算
    */
   private ItemCategory bItemCategory;
   private Date bTime;
   private User person;
   private String note;
   
   /**
   @roseuid 5504F8910398
    */
   public Budget() 
   {
    
   }

public Budget(String budgetID, double bMoney, ItemCategory bItemCategory,
		Date bTime, User person, String note) {
	super();
	this.budgetID = budgetID;
	this.bMoney = bMoney;
	this.bItemCategory = bItemCategory;
	this.bTime = bTime;
	this.person = person;
	this.note = note;
}

public String getBudgetID() {
	return budgetID;
}

public void setBudgetID(String budgetID) {
	this.budgetID = budgetID;
}

public double getBMoney() {
	return bMoney;
}

public void setBMoney(double bMoney) {
	this.bMoney = bMoney;
}

public ItemCategory getbItemCategory() {
	return bItemCategory;
}

public void setbItemCategory(ItemCategory bItemCategory) {
	this.bItemCategory = bItemCategory;
}

public Date getbTime() {
	return bTime;
}

public void setbTime(Date bTime) {
	this.bTime = bTime;
}

public User getPerson() {
	return person;
}

public void setPerson(User person) {
	this.person = person;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}
   
}
