package service;

import java.util.List;
import dao.CheckedDao;
public class CheckedService {

	private CheckedDao cd=new CheckedDao();
	private List<String> compares;
	
	public boolean Compare(String tableName, String columnName,String name) {
		// TODO Auto-generated method stub
		boolean flag=true;
		compares=cd.getAllCompareStrs(tableName,columnName);
		for(String comstr:compares){
			if(name.equals(comstr)){ 
				flag=false;
				break;
			}
		}
		return flag;
	}

}
