package org.jsp.companyapp.controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jsp.companyapp.bean.Company;

public class CompanyController {
	
	private static Map<Integer, Company> listOfCompany=new HashMap<Integer, Company>();
	
	public boolean saveCompany(Company c)
	{
		listOfCompany.put(c.getCompanyId(),c);
		return true;
	}
	
	public Company findCompanyById(int companyId)
	{
		if(listOfCompany.get(companyId)!=null)
			return listOfCompany.get(companyId);
		return null;
	}
	
	public boolean updateCompanyById(int companyId, String service)
	{
		Company c=findCompanyById(companyId);
		if(c!=null)
		{
			c.setCompanyServices(service);
			return true;
		}
		return false;
	}
	
	public boolean deleteCompanyById(int companyId) 
	{
		Company c=findCompanyById(companyId);
		if(c!=null)
		{
			listOfCompany.remove(c.getCompanyId());
			return true;
		}
		return false;
	}
	
	public List<Company> sortByNameDesc()
	{
		ArrayList<Company> al=new ArrayList<Company>(listOfCompany.values());
		Collections.sort(al,new SortByNameDesc());
		return al;
	}
	public List<Company> sortByNameAsc()
	{
		ArrayList<Company> al=new ArrayList<Company>(listOfCompany.values());
		Collections.sort(al,new SortByNameAsc());
		return al;
	}
}
