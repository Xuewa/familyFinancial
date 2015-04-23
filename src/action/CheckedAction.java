package action;


import model.ItemCategory;
import model.User;
import service.CheckedService;

public class CheckedAction {
	
	private boolean checked=true;
	private String name;
	private String tableName;
	private String columnName;
	private CheckedService cs=new CheckedService();
	private User user;
	private ItemCategory itemCategory;
	/**
	 *唯一性检验
	 **/
	public String nameUnique(){
		System.out.println(name);
		this.checked=cs.Compare(tableName, columnName, name);
		return "nameUnique";
	}
	
	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	
	
}
