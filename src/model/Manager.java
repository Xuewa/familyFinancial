//Source file: D:\\study\\大学\\大四\\上学期\\毕业设计\\mine\\roseCode\\Manager.java
package model;

public class Manager extends User 
{
   private String userID;
   private String userName;
   private String password;
   public ItemCategory theItemCategory;
   
   /**
   @roseuid 5504F891033A
    */
   public Manager() 
   {
    
   }
   
   
   public Manager(String userID, String userName, String password,
		ItemCategory theItemCategory) {
	super();
	this.userID = userID;
	this.userName = userName;
	this.password = password;
	this.theItemCategory = theItemCategory;
}


/**
   @param userName
   @param password
   @param role - 0:familyMenber;1:household;2:manager
   @param status
   @return User
   @roseuid 54FC4AB600B4
    */
   public User addUser(String userName, String password, int role, int status) 
   {
    return null;
   }
   
   /**
   @param userName
   @param password
   @param user
   @return User
   @roseuid 54FC51640369
    */
   public User updateUserInfo(String userName, String password, User user) 
   {
    return null;
   }
   
   /**
   @param userID
   @param role
   @roseuid 54FC4B4901EF
    */
   public void changeRole(String userID, int role) 
   {
    
   }
   
   /**
   @param status
   @roseuid 54FC528A03E5
    */
   public void changeUserStatus(int status) 
   {
    
   }
   
   /**
   @param catgID
   @param catgName
   @param inOrOut
   @param parentCatgID
   @return ItemCategory
   @roseuid 54FC4F7B01F4
    */
   public ItemCategory addItemCategory(String catgID, String catgName, int inOrOut, String parentCatgID) 
   {
    return null;
   }
   
   /**
   @param categID
   @param catgName
   @param inOrOut
   @param parentCatg
   @return ItemCategory
   @roseuid 54FC4F9203A8
    */
   public ItemCategory updateItemCategory(String categID, String catgName, int inOrOut, String parentCatg) 
   {
    return null;
   }
   
   /**
   @param catgID
   @roseuid 54FC4FA90228
    */
   public void deleteItemCategory(String catgID) 
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

public ItemCategory getTheItemCategory() {
	return theItemCategory;
}

public void setTheItemCategory(ItemCategory theItemCategory) {
	this.theItemCategory = theItemCategory;
}
   
   
}
