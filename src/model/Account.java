package model;
//Source file: D:\\study\\大学\\大四\\上学期\\毕业设计\\mine\\roseCode\\Account.java


public class Account 
{
   private String accountID;
   
   /**
   0:money;1:e-pay;2:bankAccount;3....
    */
   private int type;
   
   /**
   账户号码，一般用于银行账户
    */
   private String accountNum;
   
   /**
   账户登录名，一般用于电子账户
    */
   private String accountName;
   private double tMoney = 0;
   /**
   0:农行;1:工行;2:建行;3:中行
    */
   private int bank = 0;
   private String note;
   private String ownerID;
   /**
   0:frozen;1:ok
    */
   private int status=1;
   /**
   @roseuid 5504F8910174
    */
   public Account() 
   {
    
   }


public Account(String accountID, int type, String accountNum,
		String accountName, double tMoney, int bank, String note,
		String ownerID, int status) {
	super();
	this.accountID = accountID;
	this.type = type;
	this.accountNum = accountNum;
	this.accountName = accountName;
	this.tMoney = tMoney;
	this.bank = bank;
	this.note = note;
	this.ownerID = ownerID;
	this.status = status;
}



public String getAccountID() {
	return accountID;
}

public void setAccountID(String accountID) {
	this.accountID = accountID;
}

public int getType() {
	return type;
}

public void setType(int type) {
	this.type = type;
}

public String getAccountNum() {
	return accountNum;
}

public void setAccountNum(String accountNum) {
	this.accountNum = accountNum;
}

public String getAccountName() {
	return accountName;
}

public void setAccountName(String accountName) {
	this.accountName = accountName;
}

public double getTMoney() {
	return tMoney;
}

public void setTMoney(double tMoney) {
	this.tMoney = tMoney;
}


public int getBank() {
	return bank;
}

public void setBank(int bank) {
	this.bank = bank;
}

public void setOwnerID(String ownerID) {
	this.ownerID = ownerID;
}

public String getOwnerID() {
	return ownerID;
}

public void setStatus(int status) {
	this.status = status;
}

public int getStatus() {
	return status;
}


public void setNote(String note) {
	this.note = note;
}


public String getNote() {
	return note;
}
   
   
}
