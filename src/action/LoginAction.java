package action;

import model.User;

import com.opensymphony.xwork2.ActionSupport;
import service.LoginService;

public class LoginAction extends ActionSupport{
	
	private LoginService ls=new LoginService();
	private User user;
	private String msg="";
	
	
	public String login(){
		System.out.println(user);
		this.msg=ls.loginMessage(user.getUserName(), user.getPassword());
		System.out.println(this.msg);
		if (msg.contains(",")) {//验证成功，分开跳转到不同页面
			String role=msg.split(",")[1];
			if (role.equals("0")) return "manager"+SUCCESS;
			else if (role.equals("1")) return "familyMember"+SUCCESS;
			else if (role.equals("2")) return "household"+SUCCESS;
		}else {
			return ERROR;
		}
		return "";
	}
	
	
	public LoginService getLs() {
		return ls;
	}
	public void setLs(LoginService ls) {
		this.ls = ls;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
