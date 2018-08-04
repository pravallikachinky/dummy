package com.cg.plp.service;

import java.util.Collection;

import com.cg.plp.bean.Account;
import com.cg.plp.dao.AccountDao;
import com.cg.plp.dao.IAccountDao;
import com.cg.plp.exception.AccountException;

public class AccountService implements IAccountService {
	IAccountDao dao = new AccountDao();

	
	public boolean validateMobile(String phoneNum) throws AccountException {
		if (!phoneNum.matches("\\d{10}")) {
			throw new AccountException(
					"please enter mobile number with 10 digits");

		} else
			return true;
	}

	@Override
	public String createAcc(Account account) throws AccountException {

		return dao.createAcc(account);

	}

	public boolean validateName(String custName) throws AccountException {
		if (custName == null || custName.isEmpty()) {
			throw new AccountException("Name should not be empty");
		} else if (!custName.matches("[A-Z][A-Za-z]{2,}")) {
			throw new AccountException(
					"Name should start with capital letters and contain only characters");
		}
		return true;
	}

	public boolean validateEmailId(String emailId) throws AccountException {
		if (emailId == null || emailId.isEmpty()) {
			throw new AccountException("please enter the emailId");
		} else if (!emailId.matches("[A-za-z0-9]+@[a-z0-9]+\\.com")) {
			throw new AccountException("please enter valid emailid");
		}
		return true;
	}

	@Override
	public boolean validateBalance(double bal) throws AccountException {
		if (bal < 0) {
			throw new AccountException("please enter valid number");
		}
		return true;
	}

	@Override
	public boolean validateAccount(Account acc) throws AccountException {
		if (validateName(acc.getCustName())
				&& validateMobile(acc.getPhoneNum())
				&& validateEmailId(acc.getEmailId()) && validateBalance(acc.getBal())) {
			return true;
		}
		return false;
	}

	@Override
	public double showBal(String phoneNum) throws AccountException {
		if (!validateMobile(phoneNum)) {
			throw new AccountException("please enter mobile number with 10 digits");
		}
		return dao.showBal(phoneNum);
	}

	@Override
	public double deposit(String phoneNum, double amount)
			throws AccountException {
		if (!validateMobile(phoneNum)) {
			throw new AccountException("please enter mobile number with 10 digits");
		}if(amount<0){
			throw new AccountException("please enter valid number");
		}
		return dao.deposit(phoneNum, amount);
	}

	@Override
	public double withdraw(String phoneNum, double amount)
			throws AccountException {
		Account acc=dao.getDetails(phoneNum);
		if (!validateMobile(phoneNum)) {
			throw new AccountException("please enter mobile number with 10 digits");
		}if(amount<acc.getBal())
			throw new AccountException("Account balance is Low");
		return dao.withdraw(phoneNum, amount);
	}

	@Override
	public boolean fundTransfer(String phoneNum1, String phoneNum2,
			double amount) throws AccountException {
		if (!validateMobile(phoneNum1) || !validateMobile(phoneNum2))
			throw new AccountException(
					"please enter mobile number with 10 digits");
		else if (amount < 0)
			throw new AccountException(
					"Amount must be a number greater than zero");
		return dao.fundTransfer(phoneNum1, phoneNum2, amount);
	}

	@Override
	public Account getDetails(String phoneNum) throws AccountException {
		
		return dao.getDetails(phoneNum);
	}
}
