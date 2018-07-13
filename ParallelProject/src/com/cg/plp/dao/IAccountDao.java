package com.cg.plp.dao;

import java.util.Collection;

import com.cg.plp.bean.Account;
import com.cg.plp.exception.AccountException;

public interface IAccountDao {
	Collection<Account> getAllEmployee() throws AccountException;
}
