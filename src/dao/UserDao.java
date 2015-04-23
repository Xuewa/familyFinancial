package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import until.Tool;
import model.User;

public class UserDao {
	private Connection conn;
	
	/**
	 * 验证登陆
	 * @param userName
	 * @return user
	 * */
		public User queryPasswordByUserName(String userName){
			conn=Tool.getDBCon();
			String sql="select userID,password,role,status from licaiUSER where userName=?";
			PreparedStatement ps = null ;
			ResultSet rs = null ;
			User user=null;
			try {
				ps = conn.prepareStatement(sql) ;
				ps.setString(1, userName) ;
				rs = ps.executeQuery() ;
				if(rs.next()){
					String userID=rs.getString(1);
					String password=rs.getString(2);
					int role=rs.getInt(3);
					int status=rs.getInt(4);
					user=new User();
					user.setUserID(userID);
					user.setPassword(password);
					user.setRole(role);
					user.setStatus(status);
				}
				rs.close();
				ps.close() ;
				conn.close() ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user ;
		}
		
		
		/**
		 * 根据用户名，更新最后登录时间
		 * @param userName
		 * */
		public void updateLastLoginTime(String userName){
			conn=Tool.getDBCon();
			String sql="update licaiUSER set lastLoginTime=to_date(?,'yyyy-mm-dd hh24:mi') where userName=?";
			PreparedStatement ps = null ;
			try {
				ps = conn.prepareStatement(sql) ;
				Date date=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
				System.out.println(sdf.format(date));
				ps.setString(1, sdf.format(date)) ;
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

		/**
		 * 往数据库插入user
		 * @param user
		 * @return success
		 * */
		public int add(User user) {
			//=====先创建userid
			String userId=Tool.createIDByPrefix("U");
			Connection conn=Tool.getDBCon();
			PreparedStatement pstmt;
//			System.out.println("userID:"+userId);
			
			//=====插入user
			String sql="insert into licaiUSER values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			int success=0;
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				pstmt.setString(2, user.getUserName());
				pstmt.setString(3, user.getPassword());
				pstmt.setString(4, user.getName());
				pstmt.setInt(5, user.getSex());
				pstmt.setDate(6, user.getBirthday());
				pstmt.setString(7, user.getMobile());
				pstmt.setString(8, user.getEmail());
				pstmt.setString(9, user.getId());
				pstmt.setString(10, user.getRelation());
				pstmt.setDate(11, null);
				pstmt.setInt(12, user.getRole());
				
				pstmt.setInt(13, 0);			//frozen
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}
		
		/**
		 * 查出所有用户
		 **/
		public List<User> list() throws Exception{
			String sql="";
			Connection conn=Tool.getDBCon();
			sql="select * from licaiUser";//======
			List<User> users=new ArrayList<User>();
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					User user=new User();
					user.setUserID(rs.getString(1));
					user.setUserName(rs.getString(2));
					user.setName(rs.getString(4));
					user.setSex(rs.getInt(5));
					user.setBirthday(rs.getDate(6));
					user.setMobile(rs.getString(7));
					user.setEmail(rs.getString(8));
					user.setId(rs.getString(9));
					user.setRelation(rs.getString(10));
					user.setLastLoginTime(rs.getString(11).substring(0,16));
					user.setRole(rs.getInt(12));
					user.setStatus(rs.getInt(13));
					users.add(user);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("sqlException");
				throw e;
			}
			return users;
		}
		
		/**
		 * 更新用户信息
		 * */
		public int update(User user) throws SQLException{
			String sql="";
			Connection conn=Tool.getDBCon();
			sql="update licaiUser set Username=?,name=?,mobile=?,email=?,role=? where userID=?";
			int success=0;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,user.getUserName());
				pstmt.setString(2,user.getName());
				pstmt.setString(3,user.getMobile());
				pstmt.setString(4,user.getEmail());
				pstmt.setInt(5,user.getRole());
				pstmt.setString(6,user.getUserID());
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			return success;
		}
		
		/**
		 * 修改用户密码
		 * */
		public int updatePassword(User user) {
			// TODO Auto-generated method stub
			String sql="";
			Connection conn=Tool.getDBCon();
			sql="update licaiUser set password=? where userID=?";
			int success=0;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,user.getPassword());
				pstmt.setString(2,user.getUserID());
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}
		
		/**
		 * 激活用户
		 * */
		public int active(User user){
			String sql="";
			Connection conn=Tool.getDBCon();
			sql="update licaiUser set status=? where userID=?";
			int success=0;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,user.getStatus());
				pstmt.setString(2,user.getUserID());
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}
		
		/**
		 * 删除用户
		 * */
		public int delete(User user){
			return deleteById(user.getUserID());
		}
		
		/**
		 * 根据ID删除用户
		 * */
		public int deleteById(String userID){
			String sql="";
			Connection conn=Tool.getDBCon();
			sql="delete from licaiUser where userID=?";
			int success=0;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,userID);
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}
		
		/**
		 * 根据ID加载用户
		 * */
		public User loadById(String userId){
			String sql="";
			Connection conn=Tool.getDBCon();
			sql="select * from licaiUser where userId=?";
			User user=null;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, userId);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					user=new User();
					user.setUserID(rs.getString(1));
					user.setUserName(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setName(rs.getString(4));
					user.setSex(rs.getInt(5));
					user.setBirthday(rs.getDate(6));
					user.setMobile(rs.getString(7));
					user.setEmail(rs.getString(8));
					user.setId(rs.getString(9));
					user.setRelation(rs.getString(10));
					user.setLastLoginTime(rs.getString(11).substring(0,16));
					user.setRole(rs.getInt(12));
					user.setStatus(rs.getInt(13));
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
		}


		
}
