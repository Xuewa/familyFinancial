package service;

import java.util.List;

import dao.AccountDao;
import model.Account;

public class AccountService {

	private AccountDao ad=new AccountDao();
	
	public String add(Account a) {
		// TODO Auto-generated method stub
		return ad.add(a)>0?"success":"failed";
	}

	public List<Account> list(String userID) throws Exception {
		// TODO Auto-generated method stub
		return ad.list(userID);
	}
	
	public List<Account> list(String userID,int status) throws Exception {
		// TODO Auto-generated method stub
		return ad.list(userID,status);
	}

	public String delete(Account account) {
		// TODO Auto-generated method stub
		return ad.delete(account)>0?"success":"failed";
	}

	public String active(Account account) {
		// TODO Auto-generated method stub
		return ad.active(account)>0?"success":"failed";
	}

	public void deleteMultiple(String accountIDsstr) {
		// TODO Auto-generated method stub
		String[] accountIDs=accountIDsstr.split(",");
		for(String accountID:accountIDs) {
			ad.deleteById(accountID);
		}
	}
}

