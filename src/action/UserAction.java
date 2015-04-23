package action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.ServletRequestAware;
import model.User;
import service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport implements ServletRequestAware{
	
	private UserService us=new UserService();
	private User user;
	private String msg="";
	private List<User> users;
	private String userIDsstr;
	private HttpServletRequest request;
	private HttpSession session;
	
	/**
	 * 登陆
	 * */
	public String login(){
//		System.out.println(user);
		this.msg=us.loginMessage(user.getUserName(), user.getPassword());
		System.out.println(this.msg);
		if (msg.contains(",")) {//验证成功，分开跳转到不同页面
			String role=msg.split(",")[1];
			String userID=msg.split(",")[2];
			user.setUserID(userID);
			user.setRole(Integer.parseInt(role));
			session.setAttribute("user", user);
			if (role.equals("0")) return "manager"+SUCCESS;
			else if (role.equals("1")) return "familyMember"+SUCCESS;
			else if (role.equals("2")) return "houseHold"+SUCCESS;
		}else {
			return ERROR;
		}
		return "";
	}
	
	/**
	 * 退出登陆
	 * */
	public String logout(){
			session.removeAttribute("user");
		return "logout";
	}
	
	/**
	 * 录入用户信息
	 * */
	public String add(){
		msg=us.add(user);
		return msg;
	}

	/**
	 * 查出某个用户信息
	 * */
	public String loadByID() throws Exception{
		if(user.getUserID().equals("")) return "failed";
		this.setUser(us.loadByID(user.getUserID()));
		return "user";
	}
	
	/**
	 * 查出所有用户信息
	 * */
	public String list() throws Exception{
		this.setUsers(us.list());
		return "userlist";
	}
	
	/**
	 * 修改用户信息后
	 * */
	public String updatePassword() throws Exception{
//		System.out.println(user.getName());
		msg=us.updatePassword(user);
		return msg;
	}
	/**
	 * 修改用户信息后
	 * */
	public String update() throws Exception{
//		System.out.println(user.getName());
		msg=us.update(user);
		return msg;
	}
	
	/**
	 * 修改用户信息
	 * */
	public String updateInput(){
		user=us.updateInput(user);
		return "updateInput";
	}
	
	/**
	 * 删除多个用户
	 * */
	public String deleteMultiple(){
		us.deleteMultiple(userIDsstr);
		return SUCCESS;
	}
	/**
	 * 删除单个用户
	 * */
	public String delete(){
//		System.out.println(user.getUserID());
		msg=us.delete(user);
		return msg;
	}
	
	public String active() throws Exception{
		msg=us.active(user);
		return msg;
	}

	public UserService getUs() {
		return us;
	}


	public void setUs(UserService us) {
		this.us = us;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void setUserIDsstr(String userIDsstr) {
		this.userIDsstr = userIDsstr;
	}

	public String getUserIDsstr() {
		return userIDsstr;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.session = request.getSession();
	}
	
	
	
}