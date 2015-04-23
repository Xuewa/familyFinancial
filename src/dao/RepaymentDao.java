package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import until.Tool;
import model.Loan;
import model.Repayment;

public class RepaymentDao {
	private Connection conn;
	
		
		/**
		 * 往数据库插入repayment
		 * @param repayment
		 * @return success
		 * */
		public Repayment add(Repayment repayment) {
			conn=Tool.getDBCon();
			PreparedStatement pstmt;int success=0;
			try {
				String sql="select count(*) from repayment where loanID=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, repayment.getLoanID());
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) repayment.setPeriodNum(rs.getInt(1)+1);
				
				//=====先创建repaymentid
				String repaymentId=Tool.createIDByPrefix("R");
				conn=Tool.getDBCon();
				//=====插入loan
				sql="insert into Repayment values(?,?,?,?,?,?,?,to_date(?,'yyyy-MM-dd'),?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, repaymentId);
				pstmt.setInt(2, repayment.getPeriodNum());
				pstmt.setDouble(3, repayment.getRMoney());
				pstmt.setString(4, repayment.getLoanID());
				pstmt.setDouble(5, repayment.getRCapital());
				pstmt.setDouble(6, repayment.getRInterest());
				pstmt.setDouble(7, repayment.getFineMoney());
				//System.out.println(repayment.getrTime());
				pstmt.setString(8, repayment.getRTime());
				pstmt.setString(9, repayment.getAccountID());
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
		return repayment;
	}
		
		/**
		 * 查出所有贷款信息
		 * @param pageNum 
		 * @param end 
		 **/
		public List<Repayment> list(String loanID,int start, int end) throws Exception{
			String sql="";
			conn=Tool.getDBCon();
			sql=" select * from " +
					"(select rownum rn,a.type,a.accountNum,a.accountName,a.bank,r.* from Repayment r,Account a" +
					" where r.loanID=? and a.accountID=r.accountID order by r.periodNum)" +
				" where rn>=? and rn<=? ";//======
			List<Repayment> repayments=new ArrayList<Repayment>();
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, loanID);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					Repayment repayment=new Repayment();
//					//处理account
					String account="";
					//根据账户类型不同处理
					int at=rs.getInt(2);
					if(at==0) account+="(现金账户)";
					else if(at==1) account+="(电子账户)"+rs.getString(4);
					else if(at==2) {
						//bank
						if(rs.getInt(5)==1) account+="(农业银行)";
						else if(rs.getInt(5)==2) account+="(工商银行)";
						else if(rs.getInt(5)==3) account+="(建设银行)";
						else if(rs.getInt(5)==4) account+="(中国银行)";
						account+=rs.getString(3);
					}
					repayment.setAccountID(account);
					repayment.setRepaymentID(rs.getString(6));
					repayment.setPeriodNum(rs.getInt(7));
					repayment.setRMoney(rs.getDouble(8));
					repayment.setLoanID(rs.getString(9));
					repayment.setRCapital(rs.getDouble(10));
					repayment.setRInterest(rs.getDouble(11));
					repayment.setFineMoney(rs.getDouble(12));
					repayment.setRTime(rs.getString(13).substring(0,10));
					repayments.add(repayment);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return repayments;
		}
		
	
		
		
//		/**
//		 * 更改状态
//		 * @throws SQLException 
//		 * */
//		public int changeStatus(String repaymentID,int status) throws SQLException{
//			String sql="";
//			Connection conn=Tool.getDBCon();
//			sql="update Repayment set status=? where repaymentID=?";
//			int success=0;
//			try {
//				PreparedStatement pstmt=conn.prepareStatement(sql);
//				pstmt=conn.prepareStatement(sql);
//				pstmt.setInt(1,status);
//				pstmt.setString(2,repaymentID);
//				success=pstmt.executeUpdate();
//				pstmt.close();
//				conn.close();
//			}catch (SQLException e) {
//				e.printStackTrace();
//				throw e;
//			}
//			return success;
//		}
		
		
		
		/**
		 * 根据ID删除贷款
		 * */
		public int deleteById(String loanID){
			String sql="";
			Connection conn=Tool.getDBCon();
			sql="delete from Loan where loanID=?";
			int success=0;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,loanID);
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}
		
		/**
		 * 根据ID加载贷款
		 * */
		public Loan loadById(String loanID){
			String sql="";
			Connection conn=Tool.getDBCon();
			sql="select * from loan where loanId=?";
			Loan loan=null;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, loanID);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					loan=new Loan();
					loan.setLoanID(rs.getString(1));
					loan.setAccountID(rs.getString(2));
					loan.setLMoney(rs.getDouble(3));
					loan.setCapital(rs.getDouble(4));
					loan.setPeriodInterest(rs.getDouble(5));
					loan.setLPeriod(rs.getInt(6));
					loan.setLTime(rs.getString(7).substring(0,10));
					loan.setPeriodTime(rs.getInt(8));
					loan.setPeriodMoney(rs.getDouble(9));
					loan.setCatgID(rs.getString(10));
					loan.setNote(rs.getString(11));
					loan.setStatus(rs.getInt(12));
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return loan;
		}

		/**
		 *查询所有贷款的条数
		 * @param loanID 
		 * */
		public int totalCount(String loanID) {
			// TODO Auto-generated method stub
			String sql="";
			Connection conn=Tool.getDBCon();
			sql="select count(*) from Repayment where loanID=?";
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, loanID);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}


		
}
