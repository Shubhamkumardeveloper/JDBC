package com.jsp.bankapp.Controller;

import java.util.*;

import com.jsp.bankapp.bean.Bank;

public class BankController {
	
	private static Map<Integer,Bank> listOfCustomer=new HashMap<Integer,Bank>();
	
	public void saveCustomer(Bank b)
	{
		listOfCustomer.put(b.getCustId(),b);
	}
	
	public Bank findCustumerById(int custId)
	{
		if(listOfCustomer.get(custId)!=null)
			return listOfCustomer.get(custId);
		return null;
	}
	
	public boolean updateCustomerById(int custId,long newPhoneNumber)
	{
		Bank b=findCustumerById(custId);
		if(b!=null)
		{
			b.setCustPhoneNumber(newPhoneNumber);
			return true;
		}
		return false;
	}

}
