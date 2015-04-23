package model;
//Source file: D:\\study\\大学\\大四\\上学期\\毕业设计\\mine\\roseCode\\ItemCategory.java


public class ItemCategory 
{
   private String catgID;
   private String catgName;
   
   /**
   0:out;1:in
    */
   private int inOrOut = 0;
   private String parentCatgID;
   
   /**
   @roseuid 5504F89102FB
    */
   public ItemCategory() 
   {
    
   }

public ItemCategory(String catgID, String catgName, int inOrOut,
		String parentCatgID) {
	super();
	this.catgID = catgID;
	this.catgName = catgName;
	this.inOrOut = inOrOut;
	this.parentCatgID = parentCatgID;
}

public String getCatgID() {
	return catgID;
}

public void setCatgID(String catgID) {
	this.catgID = catgID;
}

public String getCatgName() {
	return catgName;
}

public void setCatgName(String catgName) {
	this.catgName = catgName;
}

public int getInOrOut() {
	return inOrOut;
}

public void setInOrOut(int inOrOut) {
	this.inOrOut = inOrOut;
}

public String getParentCatgID() {
	return parentCatgID;
}

public void setParentCatgID(String parentCatgID) {
	this.parentCatgID = parentCatgID;
}
   
}
