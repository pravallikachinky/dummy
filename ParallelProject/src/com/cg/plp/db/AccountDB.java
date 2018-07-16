package com.cg.plp.db;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.cg.plp.bean.Account;

public class AccountDB {
	
	static HashMap<String, Account> accDb= new HashMap<String, Account>();
	public static HashMap<String, Account> getacc(){
		return accDb;
	}
	
	static{
		accDb.put("1111122222" , new Account("1111122222","Swarnalatha","female",
				5000.00,"swarnalatha@gmail.com",LocalDate.now()));
		accDb.put("3333344444" , new Account("3333344444","Janardhan","male",
				3000.00,"janardhan@gmail.com",LocalDate.now()));
		accDb.put("5555566666" , new Account("5555566666","Prathyusha","female",
				6000.00, "prathyusha@gmail.com",LocalDate.now()));
	}
	
}
