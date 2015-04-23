package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import until.Tool;
import model.ItemCategory;
@SuppressWarnings("unused")
public class ItemCategoryDao {
	
	private Connection conn;
		
	/**
	 * 查出属于该父类的子类
	 * @param parentCatgID
	 * @return count
	 * */
	public List<ItemCategory> queryAllCategoriesBelongsToParent(String parentCatgID,int inOrOut) {
		Connection conn=Tool.getDBCon();
		List<ItemCategory> itemCategories=new ArrayList<ItemCategory>();
		//父类的情况要考虑
		String sql="select * from ItemCategory where ";
		if(parentCatgID.equals("")){
			sql+="parentCatgID is null and catgID like";
		}else
			sql+="parentCatgID=? and catgID like";
		sql+=inOrOut==0?" 'I%'":" 'O%'";
		PreparedStatement pstmt;
		try {
			pstmt=conn.prepareStatement(sql);
			System.out.println("getParentCatgID"+parentCatgID);
			if(!parentCatgID.equals("")) pstmt.setString(1, parentCatgID);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				ItemCategory ic=new ItemCategory();
				ic.setCatgID(rs.getString(1));
				ic.setCatgName(rs.getString(2));
				ic.setInOrOut(rs.getInt(3));
				ic.setParentCatgID(rs.getString(4));
				
				itemCategories.add(ic);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemCategories;
	}
	
	/**
	 * 查出属于该父类的最大值
	 * @param parentCatgID
	 * @return count
	 * */
	public int queryCountBelongsToParent(String parentCatgID,int inOrOut) {
		Connection conn=Tool.getDBCon();
		//父类的情况要考虑
		String sql="select count(*) from ItemCategory where ";
		if(parentCatgID.equals("")){
			sql+="parentCatgID is null and catgID like";
		}else
			sql+="parentCatgID=? and catgID like";
		sql+=inOrOut==0?" 'I%'":" 'O%'";
		System.out.println(sql);
		PreparedStatement pstmt;
		int success=0;
		try {
			pstmt=conn.prepareStatement(sql);
			if(!parentCatgID.equals("")) pstmt.setString(1, parentCatgID);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) success=rs.getInt(1);
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	public String getCatgID(int inOrOut,String parentCatgID){
		System.out.println("parentCatgID:"+parentCatgID);
		String prefix=inOrOut==0?"I":"O";
		String catgId=prefix;
		//查出属于该父类的最大的值count
//		System.out.println("ParentCatgID()"+itemCategory.getParentCatgID());
		int count=queryCountBelongsToParent(parentCatgID,inOrOut)+1;
		//判断count是几位数 1/2
		String countstr=(count-10>=0)?(Integer.toString(count)):("0"+count);
//		System.out.println("countstr"+countstr);
		//判断是父类还是子类？
		catgId+=(parentCatgID.equals(""))?countstr+"00":parentCatgID.substring(1,3)+countstr;
//		System.out.println(catgId);
		return catgId;
	}
	/**
	* 往数据库插入ItemCategory
	* @param itemCategory
	* @return success
	* @throws SQLException 
	* */
		public int add(ItemCategory itemCategory) throws SQLException {
			
		//=====先创建catgID
			//先根据收入支出，得出前缀
			String catgId=getCatgID(itemCategory.getInOrOut(),itemCategory.getParentCatgID());
			Connection conn=Tool.getDBCon();
			PreparedStatement pstmt;
			System.out.println(catgId);
		//=====插入itemCategory
			String sql="insert into ItemCategory values(?,?,?,?)";
			int success=0;
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, catgId);
				pstmt.setString(2, itemCategory.getCatgName());
				pstmt.setInt(3, itemCategory.getInOrOut());
				pstmt.setString(4, itemCategory.getParentCatgID());
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
		 * 查出所有收支类别
		 * @param inOrOut
		 * @param start
		 * @param end
		 * @return list
		 **/
		public List<ItemCategory> list(int inOrOut,int start,int end) throws Exception{
			Connection conn=Tool.getDBCon();
			//注意rownum>2是没有值的，必须写成rn>2
			String sql="select b.* from"+
							"(select rownum rn,a.* from" +
								"(select *  from Itemcategory where inOrOut=? order by catgID)a"
							+")b"
					+" where rn>=? and rn<=?";
			
			List<ItemCategory> itemCategories=new ArrayList<ItemCategory>();
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,inOrOut);
				pstmt.setInt(2,start);
				pstmt.setInt(3,end);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()){
					ItemCategory ic=new ItemCategory();
					ic.setCatgID(rs.getString(2));
					ic.setCatgName(rs.getString(3));
					ic.setInOrOut(rs.getInt(4));
					ic.setParentCatgID(rs.getString(5));
					itemCategories.add(ic);
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return itemCategories;
		}

		public ItemCategory getParentICBycatgID(String catgID) throws SQLException{
			Connection conn=Tool.getDBCon();
			String sql="select ic2.catgID,ic2.catgName from " +
					" (select ic.parentCatgID pID from ItemCategory ic where ic.catgID=?)atable,itemCategory ic2" +
					" where ic2.catgID=atable.pID";
			ItemCategory ic=null;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,catgID);
				ResultSet rs=pstmt.executeQuery();
				ic=new ItemCategory();
				if(rs.next()) {
					ic.setCatgID(rs.getString(1));
					ic.setCatgName(rs.getString(2));
				}
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			return ic;
		}
		public int update(ItemCategory ic) throws SQLException{
			Connection conn=Tool.getDBCon();
			String sql="update ItemCategory set catgName=?,parentCatgID=? where catgID=?";
			int success=0;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,ic.getCatgName());
				pstmt.setString(2,ic.getParentCatgID());
				pstmt.setString(3,ic.getCatgID());
				success=pstmt.executeUpdate();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			return success;
		}
		
		
		
		public int delete(ItemCategory ic){
			return deleteById(ic.getCatgID());
		}
		
		public int deleteById(String catgID){
			Connection conn=Tool.getDBCon();
			String sql="delete from ItemCategory where catgID=?";
			int success=0;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,catgID);
				success=pstmt.executeUpdate();
				System.out.println("delete success"+success);
				conn.commit();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}
		
		public ItemCategory loadById(String icId){
			String sql="";
			Connection conn=Tool.getDBCon();
			sql="select * from ItemCategory where catgID=?";
			ItemCategory ic=null;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, icId);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					ic=new ItemCategory();
					ic.setCatgID(rs.getString(1));
					ic.setCatgName(rs.getString(2));
					ic.setInOrOut(rs.getInt(3));
					ic.setParentCatgID(rs.getString(4));
				}
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ic;
		}

		public int totalCount(int inOrOut) throws Exception {
			// TODO Auto-generated method stub
			Connection conn=Tool.getDBCon();
			String sql="select count(*)  from Itemcategory ic where ic.inOrOut=?";
			int count=0;
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,inOrOut);
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
}
