package service;

import model.User;
import dao.LoginDao;

public class LoginService {
	LoginDao ld=new LoginDao();
	public String loginMessage(String userName,String password){
		User user=ld.queryPasswordByUserName(userName);
		if(user!=null)System.out.println(user.getRole());
		if(user==null) return "用户名不存在";
		else if(user!=null){
				if(user.getPassword().equals(password)) {
					//更新登录时间lastLoginTime
					ld.updateLastLoginTime(userName);
					return "登陆成功,"+user.getRole();
				}
				return "密码错误";
		}
	    return "";	
	}
}
