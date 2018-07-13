package com.cg.plp.dao;

import java.util.Collection;
import java.util.HashMap;

import com.cg.plp.bean.Account;
import com.cg.plp.db.AccountDB;
import com.cg.plp.exception.AccountException;

public class AccountDao implements IAccountDao {
HashMap<String, Account> accDao=AccountDB.getacc();
	@Override
	public Collection<Account> getAllEmployee() throws AccountException {
		// TODO Auto-generated method stub
		return accDao.values();
	}

}
