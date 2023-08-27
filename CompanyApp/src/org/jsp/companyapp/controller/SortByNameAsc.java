package org.jsp.companyapp.controller;

import java.util.Comparator;

import org.jsp.companyapp.bean.Company;

public class SortByNameAsc implements Comparator<Company> {

	@Override
	public int compare(Company o1, Company o2) {
		int n=o1.getCompanyName().compareTo(o2.getCompanyName());
		return n;
	}

}
