package com.cg.plp.dao;

import java.util.Collection;
import java.util.HashMap;

import com.cg.plp.bean.Account;
import com.cg.plp.db.AccountDB;
import com.cg.plp.exception.AccountException;

public class AccountDao implements IAccountDao {
HashMap<String, Account> accMap=AccountDB.getacc();
	
	@Override
	public String createAcc(Account account) throws AccountException {
		if(accMap.containsKey(account.getPhoneNum())){
			throw new AccountException("Given number already exsits:" +account.getPhoneNum());
			
		}else
			accMap.put(account.getPhoneNum() ,account);
		return account.getPhoneNum();
	}
	@Override
	public double showBal(String phoneNum) throws AccountException {
		Account acc=accMap.get(phoneNum);
		if(acc==null){
			throw new AccountException("Account does not exists");
		}
		return acc.getBal();
	}
	@Override
	public Double deposit(String phoneNum, double amount)
			throws AccountException {
		
		Account acc=accMap.get(phoneNum);
		double finalBal=0;
		if(acc==null){
			throw new AccountException("Account does not exists");
		}
		else{
			finalBal=acc.getBal()+amount;
			acc.setBal(finalBal);
		}
		return finalBal;

	}
	@Override
	public double withdraw(String phoneNum, double amount)
			throws AccountException {
		Account acc=accMap.get(phoneNum);
		double remBal;
		if(acc==null){
			throw new AccountException("Account does not exists");
		}
		if(acc.getBal()<amount){
			throw new AccountException("Account balance is low");
		}
			remBal=acc.getBal()-amount;
			acc.setBal(remBal);
		
		return acc.getBal();
	}
	@Override
	public boolean fundTransfer(String phoneNum1, String phoneNum2,
			double amount) throws AccountException {
		Account acc1=accMap.get(phoneNum1);
		Account acc2=accMap.get(phoneNum2);
		if(acc1==null||acc2==null){
			throw new AccountException("Account does not exists to transfer money");
		}
		if(acc1.getBal()<amount){
			throw new AccountException("Account balance is low to transfer");
		}
		double bal=acc1.getBal()-amount;
		acc1.setBal(bal);
		double bal2=acc2.getBal()+amount;
		acc2.setBal(bal2);
		return true;
	}
	@Override
	public Account getDetails(String phoneNum) throws AccountException {
		Account acc=accMap.get(phoneNum);
		if(acc==null){
			throw new AccountException("Account does not exist");
		}
		return acc;
	}
	


}
