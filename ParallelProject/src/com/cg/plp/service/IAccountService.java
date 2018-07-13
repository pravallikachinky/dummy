package com.cg.plp.service;

import java.util.Collection;

import com.cg.plp.bean.Account;
import com.cg.plp.exception.AccountException;

public interface IAccountService {
	Collection<Account> getAllEmployee() throws AccountException;

}
