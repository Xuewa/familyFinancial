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

public class LoanDao {
	private Connection conn;
	
		
		/**
		 * 往数据库插入loan
		 * @param loan
		 * @return success
		 * */
		public int add(Loan loan) {
			//=====先创建loanid
			String loanId=Tool.createIDByPrefix("L");
			conn=Tool.getDBCon();
			PreparedStatement pstmt;
			
			//=====插入loan
			String sql="insert into Loan values(?,?,?,?,?,?,to_date(?,'yyyy-MM-dd'),?,?,?,?,?)";
			int success=0;
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, loanId);
				pstmt.setString(2, loan.getAccountID());
				pstmt.setDouble(3, loan.getLMoney());
				pstmt.setDouble(4, loan.getCapital());
				pstmt.setDouble(5, loan.getPeriodInterest());
				pstmt.setInt(6, loan.getLPeriod());
				pstmt.setString(7, loan.getLTime());
				pstmt.setInt(8, loan.getPeriodTime());
				pstmt.setDouble(9, loan.getPeriodMoney());
				pstmt.setString(10, loan.getCatgID());
				//System.out.println(loan.getCatgID());
				pstmt.setString(11, loan.getNote());
				pstmt.setInt(12, 0);
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}
		
		/**
		 * 查出所有贷款信息
		 * @param pageNum 
		 * @param end 
		 **/
		public List<Loan> list(int start, int end) throws Exception{
			String sql="";
			conn=Tool.getDBCon();
			sql=" select * from " +
					"(select rownum rn,a.type,a.accountNum,a.accountName,a.bank,l.*,ic.catgName " +
					"from loan l,account a,itemCategory ic" +
					" where a.accountID=l.accountID and ic.catgID=l.catgID)atable" +
				" where rn>=? and rn<=? ";//======
			List<Loan> loans=new ArrayList<Loan>();
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					Loan loan=new Loan();
					
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
					loan.setAccountID(account);
					loan.setLoanID(rs.getString(6));
					loan.setLMoney(rs.getDouble(8));
					loan.setCapital(rs.getDouble(9));
					loan.setPeriodInterest(rs.getDouble(10));
					loan.setLPeriod(rs.getInt(11));
					loan.setLTime(rs.getString(12).substring(0,10));
					loan.setPeriodTime(rs.getInt(13));
					loan.setPeriodMoney(rs.getDouble(14));
					//loan.setCatgID(rs.getString(14));
					loan.setNote(rs.getString(16));
					loan.setStatus(rs.getInt(17));
					loan.setCatgID(rs.getString(18));
					loans.add(loan);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return loans;
		}
		
		/**
		 * 更新贷款信息
		 * */
		public int update(Loan loan) throws SQLException{
			Connection conn=Tool.getDBCon();
			String sql="update loan set ACCOUNTID=?,LMONEY=?,CAPITAL=?,PERIODINTEREST=?," +
				"LPERIOD=?,LTIME=to_date(?,'yyyy-MM-dd'),PERIODTIME=?,PERIODMONEY=?,CATGID=?,NOTE=? " +
				"where loanID=?";
			int success=0;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,loan.getAccountID());
				pstmt.setDouble(2,loan.getLMoney());
				pstmt.setDouble(3,loan.getCapital());
				pstmt.setDouble(4,loan.getPeriodInterest());
				pstmt.setInt(5,loan.getLPeriod());
				pstmt.setString(6,loan.getLTime());
				pstmt.setInt(7,loan.getPeriodTime());
				pstmt.setDouble(8,loan.getPeriodMoney());
				pstmt.setString(9,loan.getCatgID());
				pstmt.setString(10,loan.getNote());
				
				pstmt.setString(11,loan.getLoanID());
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
		 * 更改贷款状态
		 * @throws SQLException 
		 * */
		public int changeStatus(Loan loan) throws SQLException{
			String sql="";
			Connection conn=Tool.getDBCon();
			sql="update Loan set status=? where loanID=?";
			int success=0;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,loan.getStatus());
				pstmt.setString(2,loan.getLoanID());
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			return success;
		}
		
		
		
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
		 * */
		public int totalCount() {
			// TODO Auto-generated method stub
			String sql="";
			Connection conn=Tool.getDBCon();
			sql="select count(*) from Loan";
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
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
