package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.User;

import until.Tool;

public class LoginDao {
	
	private Connection conn;
/**
 * 验证登陆
 * @param userName
 * @return passwords
 * */
	public User queryPasswordByUserName(String userName){
		conn=Tool.getDBCon();
		String sql="select password,role from licaiUSER where userName=?";
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		User user=null;
		try {
			ps = conn.prepareStatement(sql) ;
			ps.setString(1, userName) ;
			rs = ps.executeQuery() ;
			if(rs.next()){
				String password=rs.getString(1);
				int role=rs.getInt(2);
				System.out.println("role:"+role);
				user=new User();
				user.setPassword(password);
				user.setRole(role);
			}
			
			ps.close() ;
			conn.close() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user ;
	}
	
	public void updateLastLoginTime(String userName){
		conn=Tool.getDBCon();
		String sql="update licaiUSER set lastLoginTime=? where userName=?";
		PreparedStatement ps = null ;
		try {
			ps = conn.prepareStatement(sql) ;
			Date date=new Date();
			ps.setDate(1, new java.sql.Date( date.getTime())) ;
			ps.setString(2, userName);
			int success=ps.executeUpdate();
			System.out.println("执行条数"+success);
			ps.close() ;
			conn.close() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
