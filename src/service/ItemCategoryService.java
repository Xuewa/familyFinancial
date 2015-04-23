package service;

import java.sql.SQLException;
import java.util.List;
import model.ItemCategory;
import dao.ItemCategoryDao;

public class ItemCategoryService {
	ItemCategoryDao icd=new ItemCategoryDao();
	
	/**
	 * 根据执行成功的条数，判断成功与否
	 * @param ItemCategory
	 * @return msg
	 * */
	public String add(ItemCategory ItemCategory) {
		// TODO Auto-generated method stub
		try {
			if(icd.add(ItemCategory)>0) return "success";
			else return "failed";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return e.getMessage();
		}
	}

	
	public List<ItemCategory> listByPage(int inOrOut,int pageNum) throws Exception {
		// TODO Auto-generated method stub
		int start=(pageNum-1)*10+1;
		int end=pageNum*10;
		return icd.list(inOrOut,start,end);
	}
	
	public String update(ItemCategory itemCategory,int parentChange) throws Exception{
		if(parentChange==1) {
			icd.delete(itemCategory);
			return icd.add(itemCategory)>0?"success":"fail";
		}else 
			return icd.update(itemCategory)>0?"success":"fail";
	}
	
	
	public ItemCategory updateInput(ItemCategory ItemCategory){
		return ItemCategory=icd.loadById(ItemCategory.getCatgID());
	}
	
	public String delete(ItemCategory ItemCategory){
		return icd.delete(ItemCategory)>0?"success":"fail";
	}


	public List<ItemCategory> queryAllParentCategories(int inOrOut) {
		// TODO Auto-generated method stub
		return icd.queryAllCategoriesBelongsToParent("", inOrOut);
	}


	public void deleteMultiple(String itemCategoryIDsstr) {
		// TODO Auto-generated method stub
		String[] itemCategoryIDs=itemCategoryIDsstr.split(",");
		for(String itemCategoryID:itemCategoryIDs) {
				icd.deleteById(itemCategoryID);
		}
	}


	public List<ItemCategory> secondClassList(String parentCatgID,int inOrOut) {
		// TODO Auto-generated method stub
		return icd.queryAllCategoriesBelongsToParent(parentCatgID, inOrOut);
	}


	public int totalCount(int inOrOut) throws Exception {
		// TODO Auto-generated method stub
		return icd.totalCount(inOrOut);
	}

}
