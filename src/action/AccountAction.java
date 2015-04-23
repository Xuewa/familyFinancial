package action;

import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import model.Account;
import service.AccountService;

@SuppressWarnings("serial")
public class AccountAction extends ActionSupport {
	
	private AccountService as=new AccountService();
	private Account account;
	private String msg="";
	private List<Account> accounts;
	private String accountIDsstr;
	private String userID="";
//	private User user;
	private int type=0;
	
	
	/**
	 *用户添加账户 
	 **/
	public String add(){
		if(account.getOwnerID().equals("")) return "failed";
		msg=as.add(account);
		return msg;
	}
	
	/**
	 * 删除多个用户
	 * */
	public String deleteMultiple(){
		as.deleteMultiple(accountIDsstr);
		return SUCCESS;
	}
	
	/**
	 * 激活账户
	 * */
	public String active(){
//		System.out.println(user.getUserID());
		msg=as.active(account);
		return msg;
	}
	
	/**
	 * 删除单个用户
	 * */
	public String delete(){
//		System.out.println(user.getUserID());
		msg=as.delete(account);
		return msg;
	}
	
	/**
	 *用户查看自己的所有收支日常 
	 * @throws Exception 
	 **/
	public String list() throws Exception{
		System.out.println(account);
		System.out.println(userID);
		if(account==null&&""==userID)
			return "failed";
		if(account!=null){ 
			userID=account.getOwnerID();
		}
		if(type==1&&!"".equals(userID)) {
			this.setAccounts(as.list(userID,1));
			return "accountlistjson";
		}
		this.setAccounts(as.list(userID));
		return "accountlist";
	}

	public AccountService getAs() {
		return as;
	}

	public void setAs(AccountService as) {
		this.as = as;
	}

	public Account getA() {
		return account;
	}

	public void setA(Account a) {
		this.account = a;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getAccountIDsstr() {
		return accountIDsstr;
	}

	public void setAccountIDsstr(String accountIDsstr) {
		this.accountIDsstr = accountIDsstr;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}


	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserID() {
		return userID;
	}


}
