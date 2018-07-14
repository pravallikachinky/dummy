package com.cg.plp.service;

import java.util.Collection;

import com.cg.plp.bean.Account;
import com.cg.plp.dao.AccountDao;
import com.cg.plp.dao.IAccountDao;
import com.cg.plp.exception.AccountException;

public class AccountService implements IAccountService {
 IAccountDao dao=new AccountDao();
	@Override
	public Collection<Account> getAllEmployee() throws AccountException {
		
		return dao.getAllEmployee();
	}
	public boolean validatemobile(String phoneNum) throws AccountException{
		if(!phoneNum.matches("\\d{10}")){
			throw new AccountException("please enter mobile number with 10 digits");
			
		}else
			return true;
	}
	@Override
	public String createAcc(Account account) throws AccountException {
		
		return dao.createAcc(account);
		
	}
	public boolean validateName(String custName) throws AccountException{
		if(custName==null||custName.isEmpty()){
			throw new AccountException("Name should not be empty");
		}else if(!custName.matches("[A-Z][A-Za-z]{2,}")){
			throw new AccountException("Name should start with capital letters and contain only characters");
		}
		return true;
	}
	public boolean validateEmailId(String emailId) throws AccountException{
		if(emailId==null||emailId.isEmpty()){
			throw new AccountException("please enter the emailId");
		}else if(!emailId.matches("[A-za-z0-9]+@[a-z0-9]+\\.com")){
			throw new AccountException("please enter valid emailid");
		}
		return true;
	}
	@Override
	public boolean validateBalance(double bal) throws AccountException {
		if(bal<0){
			throw new AccountException("please enter valid number");
		}
		return true;
	}
	@Override
	public boolean validateAccount(Account acc) throws AccountException {
		if(validateName(acc.getCustName()) && validatemobile
				(acc.getPhoneNum()) && validateEmailId(acc.getEmailId())){
		return true;
	}
		return false;
		}
	
  
}
