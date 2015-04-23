package model;

import java.sql.Date;

//Source file: D:\\study\\大学\\大四\\上学期\\毕业设计\\mine\\roseCode\\User.java


public class User 
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
   private String email;
   private String id;
   private String relation;
   private String lastLoginTime;
   
   
   /**
   0:manager;1:familyMember;2:household
    */
   private int role = 1;
   
   /**
   0:frozen;1:ok
    */
   private int status = 0;
   
   /**
   @roseuid 5504F89100A9
    */
   public User() 
   {
    
   }

public User(String userID, String userName, String password, String name,
		int sex, Date birthday, String mobile, String id, String relation,
		int role, int status) {
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getLastLoginTime() {
	return lastLoginTime;
}

public void setLastLoginTime(String lastLoginTime) {
	this.lastLoginTime = lastLoginTime;
}
   
}
