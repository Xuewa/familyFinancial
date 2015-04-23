package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import until.Tool;
import model.Account;
import model.UsualActivity;

public class AccountDao {

		/**
		 * 往数据库插入account
		 * @param user
		 * @return success
		 * */
		public int add(Account account) {
			//=====先创建accountid
			String accountId=Tool.createIDByPrefix("A");
			Connection conn=Tool.getDBCon();
			PreparedStatement pstmt;
//			System.out.println("userID:"+userId);
			
			//=====插入account
			String sql="insert into Account values(?,?,?,?,?,?,?,?,?)";
			int success=0;
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, accountId);
				pstmt.setInt(2, account.getType());
				pstmt.setString(3, account.getAccountNum());
				pstmt.setString(4, account.getAccountName());
				pstmt.setDouble(5, account.getTMoney());
				pstmt.setInt(6, account.getBank());
				pstmt.setString(7, account.getNote());
				pstmt.setString(8, account.getOwnerID());
				pstmt.setInt(9, account.getStatus());
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}

		public List<Account> list(String userID) throws Exception {
			// TODO Auto-generated method stub
			Connection conn=Tool.getDBCon();
			String sql="select * from account where ownerID=?";//======
			List<Account> accounts=new ArrayList<Account>();
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, userID);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					Account account=new Account();
					account.setAccountID(rs.getString(1));
					account.setType(rs.getInt(2));
					account.setAccountNum(rs.getString(3));
					account.setAccountName(rs.getString(4));
					account.setTMoney(rs.getDouble(5));
					account.setBank(rs.getInt(6));
					account.setNote(rs.getString(7));
					account.setStatus(rs.getInt(9));
					accounts.add(account);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("sqlException");
				throw e;
			}
			return accounts;
		}
		
		public List<Account> list(String userID,int status) throws Exception {
			// TODO Auto-generated method stub
			Connection conn=Tool.getDBCon();
			String sql="select * from account where ownerID=? and status=?";//======
			List<Account> accounts=new ArrayList<Account>();
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, userID);
				pstmt.setInt(2, status);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					Account account=new Account();
					account.setAccountID(rs.getString(1));
					account.setType(rs.getInt(2));
					account.setAccountNum(rs.getString(3));
					account.setAccountName(rs.getString(4));
					account.setTMoney(rs.getDouble(5));
					account.setBank(rs.getInt(6));
					account.setNote(rs.getString(7));
					account.setStatus(rs.getInt(9));
					accounts.add(account);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("sqlException");
				throw e;
			}
			return accounts;
		}

		public int delete(Account account) {
			// TODO Auto-generated method stub
			return deleteById(account.getAccountID());
		}
		
		/**
		 * 根据ID删除用户
		 * */
		public int deleteById(String accountID){
			Connection conn=Tool.getDBCon();
			String sql="delete from account where accountID=?";
			int success=0;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,accountID);
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}

		public int active(Account account) {
			// TODO Auto-generated method stub
			String sql="";
			Connection conn=Tool.getDBCon();
			sql="update account set status=? where accountID=?";
			int success=0;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,account.getStatus());
				pstmt.setString(2,account.getAccountID());
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}

		public int updateTMoney(UsualActivity ua) {
			// TODO Auto-generated method stub
			Connection conn=Tool.getDBCon();
			int tMoney=0,success=0;
			try {
				//查出账户余额
				System.out.println("accountID:"+ua.getAccountID());
				String sql="select tMoney from account where accountID=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,ua.getAccountID());
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) tMoney=rs.getInt(1);
				else return 0;
				System.out.println("tMoney:"+tMoney);
				//计算余额 
				if(ua.getInOrOut()==0) tMoney+=ua.getMoney();
				else if(ua.getInOrOut()==1) tMoney-=ua.getMoney();
				//余额不足
				if(tMoney<0) return 2;
				sql="update account set tMoney=? where accountID=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,tMoney);
				pstmt.setString(2,ua.getAccountID());
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
			
		}

		
		

}
