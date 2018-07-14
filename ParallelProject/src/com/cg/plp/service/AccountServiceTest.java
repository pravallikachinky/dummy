package com.cg.plp.service;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.cg.plp.bean.Account;
import com.cg.plp.exception.AccountException;

public class AccountServiceTest {
	Account acc=new Account();
	IAccountService service;
	@Before
	public void init() {
		service=new AccountService();
	}


	@Test
	public void testValidateMobile()  {
		
		acc.setCustName("Pravallika");
		acc.setPhoneNum("3333344446");
		acc.setBal(50000.00);
		acc.setEmailId("pravallika@gmail.com");
		acc.setDoj(LocalDate.now());
		try {
			String mob=service.createAcc(acc);
			if(service.validatemobile(mob))
				System.out.println("Account is created for mobile number " +mob);
		} catch (AccountException e) {
		   // System.out.println("please");
			assertEquals("please enter mobile number with 10 digits",e.getMessage());
			System.out.println("please enter mobile number with 10 digits");
		}
		
	}
	
	@Test
	public void testValidateName(){
		acc.setCustName("Pravallika");
		acc.setPhoneNum("3333344444");
		acc.setBal(50000.00);
		acc.setEmailId("pravallika@gmail.com");
		acc.setDoj(LocalDate.now());
		try {
			
			if(service.validateName(acc.getCustName()))
				System.out.println("Account is created for mobile number " +acc.getPhoneNum());
		} catch (AccountException e) {
			System.out.println("Name should not be empty");
		assertEquals("Name should not be empty",e.getMessage());
		
	}
  }
	@Test
	public void testValidateName1(){
		acc.setCustName("Pravallika");
		acc.setPhoneNum("3333344444");
		acc.setBal(50000.00);
		acc.setEmailId("pravallika@gmail.com");
		acc.setDoj(LocalDate.now());
	
		try {
			if(service.validateName(acc.getCustName()))
				System.out.println("Account is created for mobile number " +acc.getPhoneNum());
		} catch (AccountException e) {
			System.out.println("Name should start with capital letters and contain only characters");
		assertEquals("Name should start with capital letters and contain only characters",e.getMessage());
	}
  }
	@Test
	public void testValidateEmailId(){
		acc.setCustName("Pravallika");
		acc.setPhoneNum("3333344444");
		acc.setBal(50000.00);
		acc.setEmailId("pravallika@gmail.com");
		acc.setDoj(LocalDate.now());
		try{
			if(service.validateEmailId(acc.getEmailId()))
				System.out.println("Account is created with mobile number " +acc.getPhoneNum());
		}catch(AccountException e){
			System.out.println("please enter the emailId as it should not be empty");
			assertEquals("please enter the emailId",e.getMessage());
		}
	}
	@Test
	public void testValidateEmailId1(){
		acc.setCustName("Pravallika");
		acc.setPhoneNum("3333344444");
		acc.setBal(50000.00);
		acc.setEmailId("pravallika@gmail.com");
		acc.setDoj(LocalDate.now());
		try{
			if(service.validateEmailId(acc.getEmailId()))
				System.out.println("Account created with mobile number " +acc.getPhoneNum());
		}catch(AccountException e){
			System.out.println("please enter valid emailId");
			assertEquals("please enter valid emailid",e.getMessage());
		}
	}
	@Test
	public void testBal(){
		acc.setCustName("Pravallika");
		acc.setPhoneNum("3333344444");
		acc.setBal(50000.00);
		acc.setEmailId("pravallikagmail.com");
		acc.setDoj(LocalDate.now());
		try {
			if(service.validateBalance(acc.getBal())){
				System.out.println("Account is created for mobile number " +acc.getPhoneNum());
			}
		
		} catch (AccountException e) {
			System.out.println("Please enter valid balance");
			assertEquals("please enter valid number",e.getMessage());
		}
	}
	@Test
	public void testCreateAcc(){
		acc.setCustName("Pravallika");
		acc.setPhoneNum("8978511218");
		acc.setBal(-50000.00);
		acc.setEmailId("hello@gmail.com");
		acc.setDoj(LocalDate.now());
		try {
			if(service.validateAccount(acc)){
				String phone=service.createAcc(acc);
				System.out.println("Your account is successfully created with mobile number:" +phone);
			}
		} catch (AccountException e) {
			System.out.println();
			System.err.println(e.getMessage());
			System.out.println();
			
		}
	}
}
