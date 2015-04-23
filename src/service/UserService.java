package service;

import java.util.List;

import model.User;
import dao.UserDao;

public class UserService {
	UserDao ud=new UserDao();
	
	/**
	 * 根据用户名和密码，返回验证信息
	 * @param userName,password
	 * @return msg
	 * */
	public String loginMessage(String userName,String password){
		User user=ud.queryPasswordByUserName(userName);
//		if(user!=null)System.out.println(user.getRole());
		if(user==null) return "用户名不存在";
		else if(user!=null){
				if(user.getPassword().equals(password)) {
					if(user.getStatus()==1){
						//更新登录时间lastLoginTime
						ud.updateLastLoginTime(userName);
						return "登陆成功,"+user.getRole()+","+user.getUserID();
					}else{//未激活
						return "用户还未激活";
					}
				}
				return "密码错误";
		}
	    return "";	
	}
	
	/**
	 * 根据执行成功的条数，判断成功与否
	 * @param user
	 * @return msg
	 * */
	public String add(User user) {
		// TODO Auto-generated method stub
		if(ud.add(user)>0) return "success";
		else return "failed";
	}

	/**
	 * 根据ID查出用户信息
	 * @return users
	 * */
	public User loadByID(String userID) throws Exception {
		// TODO Auto-generated method stub
		return ud.loadById(userID);
	}
	
	/**
	 * 查出所有用户信息
	 * @return users
	 * */
	public List<User> list() throws Exception {
		// TODO Auto-generated method stub
		return ud.list();
	}
	/**
	 * 修改用户密码
	 * @return msg
	 * */
	public String updatePassword(User user) {
		// TODO Auto-generated method stub
		return ud.updatePassword(user)>0?"updPaswSuccess":"failed";
	}
	
	/**
	 * 修改用户信息
	 * @return msg
	 * */
	public String update(User user) throws Exception{
		return ud.update(user)>0?"success":"failed";
	}
	
	/**
	 * 修改用户状态
	 * @return msg
	 * */
	public String active(User user){
		return ud.active(user)>0?"success":"fail";
	}
	
	public User updateInput(User user){
		return user=ud.loadById(user.getUserID());
	}
	
	public String delete(User user){
		return ud.delete(user)>0?"success":"fail";
	}

	public void deleteMultiple(String userIDsstr) {
		// TODO Auto-generated method stub
		String[] userIDs=userIDsstr.split(",");
		for(String userID:userIDs) {
			System.out.println(userID);
			ud.deleteById(userID);
		}
	}

	
	
}
