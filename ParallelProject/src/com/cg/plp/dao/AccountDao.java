package com.cg.plp.dao;

import java.util.Collection;
import java.util.HashMap;

import com.cg.plp.bean.Account;
import com.cg.plp.db.AccountDB;
import com.cg.plp.exception.AccountException;

public class AccountDao implements IAccountDao {
HashMap<String, Account> accMap=AccountDB.getacc();
	@Override
	public Collection<Account> getAllEmployee() throws AccountException {
		// TODO Auto-generated method stub
		return accMap.values();
	}
	@Override
	public String createAcc(Account account) throws AccountException {
		if(accMap.containsKey(account.getPhoneNum())){
			throw new AccountException("Given number already exsits:" +account.getPhoneNum());
			
		}else
			accMap.put(account.getPhoneNum() ,account);
		return account.getPhoneNum();
	}
	


}
