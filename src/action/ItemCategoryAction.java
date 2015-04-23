package action;

import java.util.List;

import model.ItemCategory;
import service.ItemCategoryService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ItemCategoryAction extends ActionSupport{
	
	private ItemCategoryService ics=new ItemCategoryService();
	private ItemCategory itemCategory;
	private String msg="";
	private List<ItemCategory> itemCategories;
	private int parentChange=0;
	private int inOrOut=0;
	private String parentCatgID="";
	private int type=0;//调用方式，0：非ajax，1：ajax
	private int pageNum=1;
	private int totalCount=0;
	private String itemCategoryIDsstr;
	
	/**
	* 添加前加载所有的父类
	* @param inOrOut
	* @return itemCategories
	* */
	public String addInput(){
//		System.out.println(type);
		itemCategories=ics.queryAllParentCategories(inOrOut);
		return "addInput"+type;
	}
	
	
   /**
	* 添加收支类别
	* */
	public String add(){
		msg=ics.add(itemCategory);
		return msg;
	}

	/**
	 * 查出所有收支类别
	 * @throws Exception 
	 * */
	public String list() throws Exception{
		this.setItemCategories(ics.listByPage(inOrOut,pageNum));
		this.setTotalCount(ics.totalCount(inOrOut));
		if(type==1) return "itemCategorylist1";
		return "itemCategorylist0";
	}
	
	/**
	 * 根据父ID查出所有所有子类别
	 * @throws Exception 
	 * */
	public String secondClassList() throws Exception{
		//System.out.println("itemCategory:"+itemCategory.getParentCatgID());
		this.setItemCategories(ics.secondClassList(parentCatgID,inOrOut));
//		System.out.println("itemCategoriessize:"+itemCategories.size());
		return "secondClassList";
	}
	/**
	 * 修改收支类别信息后
	 * */
	public String update() throws Exception{
//		System.out.println(itemCategory.getCatgName());
		ics.update(itemCategory,parentChange);
		return SUCCESS;
	}
	
	/**
	 * 修改收支类别信息
	 * */
	public String updateInput(){
		itemCategories=ics.queryAllParentCategories(inOrOut);
		itemCategory=ics.updateInput(itemCategory);
		return "updateInput"+type;
	}
	
	/**
	 * 删除多个收支类别
	 * */
	public String deleteMultiple(){
		ics.deleteMultiple(itemCategoryIDsstr);
		return SUCCESS;
	}
	
	/**
	 * 删除收支类别
	 * */
	public String delete(){
		ics.delete(itemCategory);
		return SUCCESS;
	}
	
	

	public ItemCategoryService getIcs() {
		return ics;
	}

	public void setIcs(ItemCategoryService ics) {
		this.ics = ics;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<ItemCategory> getItemCategories() {
		return itemCategories;
	}

	public void setItemCategories(List<ItemCategory> itemCategories) {
		this.itemCategories = itemCategories;
	}


	public int getInOrOut() {
		return inOrOut;
	}


	public void setInOrOut(int inOrOut) {
		this.inOrOut = inOrOut;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}

	public int getParentChange() {
		return parentChange;
	}

	public void setParentChange(int parentChange) {
		this.parentChange = parentChange;
	}


	public String getItemCategoryIDsstr() {
		return itemCategoryIDsstr;
	}


	public void setItemCategoryIDsstr(String itemCategoryIDsstr) {
		this.itemCategoryIDsstr = itemCategoryIDsstr;
	}


	public void setParentCatgID(String parentCatgID) {
		this.parentCatgID = parentCatgID;
	}


	public String getParentCatgID() {
		return parentCatgID;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getTotalCount() {
		return totalCount;
	}

}