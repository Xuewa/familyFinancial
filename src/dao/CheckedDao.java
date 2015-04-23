package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import until.Tool;

public class CheckedDao {

	private Connection conn;
	public List<String> getAllCompareStrs(String tableName, String columnName) {
		// TODO Auto-generated method stub
		conn=Tool.getDBCon();
		List<String> strs=new ArrayList<String>();
		String sql="select "+columnName+" from "+tableName;
		PreparedStatement ps = null ;
		ResultSet rs = null ;
		try {
			ps = conn.prepareStatement(sql) ;
			rs = ps.executeQuery() ;
			while(rs.next()){
				String col=rs.getString(1);
				strs.add(col);
			}
			rs.close();
			ps.close() ;
			conn.close() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strs;
	}

}
