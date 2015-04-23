package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import until.Tool;
import model.UsualActivity;

public class UsualActivity{

	/**
	*添加用户
	*/
	public void add(User user){
		//=====先创建id
		String UsualActivityId=Tool.createIDByPrefix("UA");
		Connection conn=Tool.getDBCon();
	
		System.out.println("UsualActivityID:"+UsualActivityId);
		
		//=====插入user
		String sql="insert into USUALACTIVITY values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getName());
			pstmt.setString(5, user.getSex());
			pstmt.setString(6, user.getBirthday());
			pstmt.setString(7, user.getMobile());
			pstmt.setString(8, user.getEmail());
			pstmt.setString(9, user.getId());
			pstmt.setString(10, user.getRelation());
			pstmt.setString(11, user.getRole());
			pstmt.setString(12, user.getStatus());
			pstmt.setString(13, user.getLastLoginTime());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	*根据ID删除用户
	*/
	public int deleteByID(String userId){
		int success=0;
		String sql="delete from licaiUSER where userid=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			success=pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	/**
	*根据ID修改用户信息
	*/
	public int updateByID(User user){
		int success=0;
		String sql="update licaiUSER set userName=?,password=?,name=?,sex=?,birthday=?,mobile=?,emial=?,id=?,relation=?,role=?,status=?,lastLoginTime=? from licaiUSER where userid=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getSex());
			pstmt.setString(5, user.getBirthday());
			pstmt.setString(6, user.getMobile());
			pstmt.setString(7, user.getEmail());
			pstmt.setString(8, user.getId());
			pstmt.setString(9, user.getRelation());
			pstmt.setString(10, user.getRole());
			pstmt.setString(11, user.getStatus());
			pstmt.setString(12, user.getLastLoginTime());
			pstmt.setString(13, user.getUserId());
			success=pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	
}
