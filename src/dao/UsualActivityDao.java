package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import until.Tool;
import vo.UACount;
import model.UsualActivity;

public class UsualActivityDao {

		/**
		 * 往数据库插入ua
		 * @param ua
		 * @return success
		 * */
		public int add(UsualActivity ua) {
			//=====先创建uaid
			String uaId=Tool.createIDByPrefix("UA");
			Connection conn=Tool.getDBCon();
			PreparedStatement pstmt;
			
			//=====插入ua
			String sql="insert into UsualActivity values(?,?,?,?,?,?,to_date(?,'YYYY-MM-DD HH24:MI'),?)";
			int success=0;
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, uaId);
				pstmt.setString(2, ua.getUserID());
				pstmt.setString(3, ua.getAccountID());
				pstmt.setString(4, ua.getCatgID());
				pstmt.setDouble(5, ua.getMoney());
				pstmt.setString(6, ua.getNote());
				pstmt.setString(7, ua.getTime());
				pstmt.setInt   (8, ua.getInOrOut());
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}

		/**
		 * 分页查询某时间段内的所有收支
		 * @param userID
		 * @param beginTime
		 * @param endTime
		 * @param start
		 * @param end
		 * */
		public List<UsualActivity> list(String userID, String beginTime,String endTime,int start,int end) throws Exception {
			// TODO Auto-generated method stub
			System.out.println(beginTime);
			System.out.println(endTime);
			Connection conn=Tool.getDBCon();
			String sql=
				"select b.* from "+
					"(select rownum rn,atable.* from "+
						"(select u.userName," +//user
							"a.type,a.accountNum,a.accountName,a.bank," +//account
							"ic.catgName," +//ic
							"ua.usualActivityID,ua.inOrOut,ua.money,ua.note,to_char(ua.time,'yyyy-MM-dd hh24:mi') " +//ua
						"from usualactivity ua,account a,licaiuser u,itemCategory ic "+ 
						"where (ua.userID=?)and (ua.userID=u.userID)and " +
							"(ua.accountID=a.accountID)and " +
							"(ua.catgID=ic.catgID)and " +
							"(to_char(ua.time,'yyyy-MM-dd hh24:mi') between ? and ?) order by ua.time)atable "+
					")b "+
				"where rn>=? and rn<=?";
			System.out.println(sql);
			List<UsualActivity> uass=new ArrayList<UsualActivity>();
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, userID);
				pstmt.setString(2, beginTime);
				pstmt.setString(3, endTime);
				pstmt.setInt(4, start);
				pstmt.setInt(5, end);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					UsualActivity ua=new UsualActivity();
					ua.setUserID(rs.getString(2));//username
					//处理account
					String account="";
					//根据账户类型不同处理
					int at=rs.getInt(3);
					if(at==0) account+="(现金账户)";
					else if(at==1) account+="(电子账户)"+rs.getString(5);
					else if(at==2) {
						//bank
						if(rs.getInt(6)==1) account+="(农业银行)";
						else if(rs.getInt(6)==2) account+="(工商银行)";
						else if(rs.getInt(6)==3) account+="(建设银行)";
						else if(rs.getInt(6)==4) account+="(中国银行)";
						account+=rs.getString(4);
					}
//					System.out.println("account:"+account);
					ua.setAccountID(account);
					//ic
					ua.setCatgID(rs.getString(7));
					ua.setUsualActivityID(rs.getString(8));
					ua.setInOrOut(rs.getInt(9));
					ua.setMoney(rs.getDouble(10));
					ua.setNote(rs.getString(11));
					//time
					ua.setTime(rs.getString(12));
					uass.add(ua);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return uass;
		}
		
		/**
		 * 查询某时间段内的所有收支条数
		 * @param userID
		 * @param beginTime
		 * @param endTime
		 * */
		public int totalCount(String userID, String beginTime, String endTime) throws Exception {
			// TODO Auto-generated method stub
			Connection conn=Tool.getDBCon();
			String sql="select count(*)  from usualActivity " +
					"where (userID=?) and (to_char(time,'yyyy-MM-dd hh24:mi') between ? and ?)";
			int count=0;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,userID);
				pstmt.setString(2,beginTime);
				pstmt.setString(3,endTime);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()){
					count=rs.getInt(1);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("sqlException");
				throw e;
			}
			return count;
		}
		
		/**
		 * 统计查询某时间段内的各二级分类的总收入/支出
		 * @param inOrOut
		 * @param beginTime
		 * @param endTime
		 * */
		public List<UACount> countGroupbyCatgID(String userID,int inOrOut, String beginTime,String endTime) throws Exception {
			// TODO Auto-generated method stub
			Connection conn=Tool.getDBCon();
			String sql=
				"select  pic.catgName,sum(money) from"+
				  "(select ua.money,ua.catgid,ic.catgname cname,ic.parentcatgid " +
				  	"from usualactivity ua,itemCategory ic "+
				           " where (ua.userID =?) and (ua.inOrOut=? ) and "+
				               " (to_char(ua.time,'yyyy-MM-dd') " +
				               "	between ? and ?) and "+ 
				                  " ua.catgID=ic.catgID)atable,itemcategory pic "+
				   "where pic.catgid=atable.parentcatgid "+
				   "group by pic.catgName";
			System.out.println(sql);
			List<UACount> uacs=new ArrayList<UACount>();
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, userID);
				pstmt.setInt(2, inOrOut);
				pstmt.setString(3, beginTime);
				pstmt.setString(4, endTime);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					UACount uac=new UACount();
					uac.setColunm(rs.getString(1));//catgName
					uac.setSumMoney(rs.getDouble(2));//catgName
					uacs.add(uac);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return uacs;
		}
		
		/**
		 * 统计查询某年段内的各月份的总收入/支出
		 * @param inOrOut
		 * @param beginTime
		 * @param endTime
		 * @throws Exception 
		 * */
		public List<UACount> countGroupbyMonth(String userID, int inOrOut,String beginTime, String endTime) throws Exception {
			// TODO Auto-generated method stub
			Connection conn=Tool.getDBCon();
			String sql=
				"select distinct to_char(time,'mm') monthc ,sum(money) "+
				"from usualactivity "+
				"where userID=? and inOrOut=? and " +
				"to_char(time,'yyyy-mm-dd') between ? and ? "+
				"group by to_char(time,'mm') "+
				"order by to_char(time,'mm') ";
			System.out.println(sql);
			List<UACount> uacs=new ArrayList<UACount>();
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, userID);
				pstmt.setInt(2, inOrOut);
				pstmt.setString(3, beginTime);
				pstmt.setString(4, endTime);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					UACount uac=new UACount();
					uac.setColunm(rs.getString(1));//month
					uac.setSumMoney(rs.getDouble(2));//money
					uacs.add(uac);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return uacs;
		}
		
		/**
		 * 删除收支
		 * @param ua
		 * */
		public int delete(UsualActivity ua){
			return deleteById(ua.getUsualActivityID());
		}
		
		/**
		 * 根据ID删除日常收支
		 * @param usualActivityID
		 * */
		public int deleteById(String usualActivityID){
			Connection conn=Tool.getDBCon();
			String sql="delete from UsualActivity where usualActivityID=?";
			int success=0;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,usualActivityID);
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}

		public UsualActivity loadByID(String usualActivityID) throws SQLException {
			// TODO Auto-generated method stub
			String sql="";
			Connection conn=Tool.getDBCon();
			sql="select * from usualActivity where usualActivityID=?";
			UsualActivity ua=null;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, usualActivityID);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					ua=new UsualActivity();
					ua.setUsualActivityID(rs.getString(1));
					ua.setUserID(rs.getString(2));
					ua.setAccountID(rs.getString(3));
					ua.setCatgID(rs.getString(4));
					ua.setMoney(rs.getDouble(5));
					ua.setNote(rs.getString(6));
					ua.setTime(rs.getString(7));
					ua.setInOrOut(rs.getInt(8));
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			return ua;
		}

		public int update(UsualActivity ua) throws SQLException {
			// TODO Auto-generated method stub
			Connection conn=Tool.getDBCon();
			String sql="update UsualActivity set accountID=?,catgID=?,money=?,note=?,time=to_date(?,'YYYY-MM-DD HH24:MI') where usualActivityID=?";
			int success=0;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,ua.getAccountID());
				pstmt.setString(2,ua.getCatgID());
				pstmt.setDouble(3,ua.getMoney());
				pstmt.setString(4,ua.getNote());
				pstmt.setString(5,ua.getTime());
				pstmt.setString(6,ua.getUsualActivityID());
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			return success;
		}

		public List<UACount> repaymentCountGroupbyCatgID(String beginTime,String endTime) throws Exception {
			// TODO Auto-generated method stub
			Connection conn=Tool.getDBCon();
			String sql=
				"select  pic.catgName,sum(rmoney) from"+
				  "(select re.rmoney,l.catgid,ic.catgname cname,ic.parentcatgid " +
				  		"from repayment re,itemCategory ic,loan l "+
				  		" where (re.loanID =l.loanID) and (to_char(re.rtime,'yyyy-MM-dd') " +
				           "between ? and ?) and l.catgID=ic.catgID)atable" +
				    ",itemcategory pic "+
				   "where pic.catgid=atable.parentcatgid "+
				   "group by pic.catgName";
			System.out.println(sql);
			List<UACount> uacs=new ArrayList<UACount>();
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, beginTime);
				pstmt.setString(2, endTime);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					UACount uac=new UACount();
					uac.setColunm(rs.getString(1));//catgName
					uac.setSumMoney(rs.getDouble(2));//catgName
					uacs.add(uac);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return uacs;
		}

		public List<UACount> famCountGroupbyMonth(int inOrOut,String beginTime, String endTime) throws Exception {
			// TODO Auto-generated method stub
			Connection conn=Tool.getDBCon();
			String sql=
				"select distinct to_char(time,'mm') monthc ,sum(money) "+
				"from usualactivity "+
				"where inOrOut=? and " +
				"to_char(time,'yyyy-mm-dd') between ? and ? "+
				"group by to_char(time,'mm') "+
				"order by to_char(time,'mm') ";
			System.out.println(sql);
			List<UACount> uacs=new ArrayList<UACount>();
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, inOrOut);
				pstmt.setString(2, beginTime);
				pstmt.setString(3, endTime);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					UACount uac=new UACount();
					uac.setColunm(rs.getString(1));//month
					uac.setSumMoney(rs.getDouble(2));//money
					uacs.add(uac);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return uacs;
		}

		public List<UACount> famCountGroupbyCatgID( int inOrOut,
				String beginTime, String endTime) throws Exception {
			// TODO Auto-generated method stub
			Connection conn=Tool.getDBCon();
			String sql=
				"select  pic.catgName,sum(money) from"+
				  "(select ua.money,ua.catgid,ic.catgname cname,ic.parentcatgid " +
				  	"from usualactivity ua,itemCategory ic "+
				           " where (ua.inOrOut=? ) and "+
				               " (to_char(ua.time,'yyyy-MM-dd') between ? and ?) and "+ 
				                  " ua.catgID=ic.catgID)atable,itemcategory pic "+
				   "where pic.catgid=atable.parentcatgid "+
				   "group by pic.catgName";
			System.out.println(sql);
			List<UACount> uacs=new ArrayList<UACount>();
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, inOrOut);
				pstmt.setString(2, beginTime);
				pstmt.setString(3, endTime);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					UACount uac=new UACount();
					uac.setColunm(rs.getString(1));//catgName
					uac.setSumMoney(rs.getDouble(2));//catgName
					uacs.add(uac);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return uacs;
		}

}
