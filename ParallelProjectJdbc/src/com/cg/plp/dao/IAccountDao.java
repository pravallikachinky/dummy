package com.cg.plp.dao;

import java.util.Collection;

import com.cg.plp.bean.Account;
import com.cg.plp.exception.AccountException;

public interface IAccountDao {
	public String createAcc(Account account) throws AccountException;
	 double showBal(String phoneNum) throws AccountException;
	 Double deposit(String phoneNum,double amount)throws AccountException;
	 double withdraw(String phoneNum,double amount)throws AccountException;
	 boolean fundTransfer(String phoneNum1,String phoneNum2,double amount)throws AccountException;
	 Account getDetails(String phoneNum) throws AccountException;
}
