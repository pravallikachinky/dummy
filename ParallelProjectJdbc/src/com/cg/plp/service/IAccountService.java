package com.cg.plp.service;

import java.util.Collection;

import com.cg.plp.bean.Account;
import com.cg.plp.exception.AccountException;

public interface IAccountService {
	
	double showBal(String phoneNum) throws AccountException;
	double deposit(String phoneNum,double amount)throws AccountException;
	 double withdraw(String phoneNum,double amount)throws AccountException;
	 boolean fundTransfer(String phoneNum1,String phoneNum2,double amount)throws AccountException;
	 Account getDetails(String phoneNum) throws AccountException;
	 
	boolean validateMobile(String mob)throws AccountException;
	String createAcc(Account account) throws AccountException;
	 boolean validateName(String custName) throws AccountException;
	 boolean validateEmailId(String emailId) throws AccountException;
	 boolean validateBalance(double bal) throws AccountException;
	 boolean validateAccount(Account acc) throws AccountException;
}
