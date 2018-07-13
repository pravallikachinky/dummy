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
	public boolean 

}
