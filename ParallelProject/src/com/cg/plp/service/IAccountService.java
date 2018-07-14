package com.cg.plp.service;

import java.util.Collection;

import com.cg.plp.bean.Account;
import com.cg.plp.exception.AccountException;

public interface IAccountService {
	Collection<Account> getAllEmployee() throws AccountException;

	boolean validatemobile(String mob)throws AccountException;
	public String createAcc(Account account) throws AccountException;
	public boolean validateName(String custName) throws AccountException;
	public boolean validateEmailId(String emailId) throws AccountException;
	public boolean validateBalance(double bal) throws AccountException;
	public boolean validateAccount(Account acc) throws AccountException;
}
