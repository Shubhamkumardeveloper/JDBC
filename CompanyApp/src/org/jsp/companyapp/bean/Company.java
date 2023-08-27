package org.jsp.companyapp.bean;

public class Company {
	
	private int companyId;
	private String companyName;
	private String headQuarter;
	private String companyCeoName;
	private String companyServices;
	private String companyGstNo;
	private String companyRating;
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getHeadQuarter() {
		return headQuarter;
	}
	public void setHeadQuarter(String headQuarter) {
		this.headQuarter = headQuarter;
	}
	public String getCompanyCeoName() {
		return companyCeoName;
	}
	public void setCompanyCeoName(String companyCeoName) {
		this.companyCeoName = companyCeoName;
	}
	public String getCompanyServices() {
		return companyServices;
	}
	public void setCompanyServices(String companyServices) {
		this.companyServices = companyServices;
	}
	public String getCompanyGstNo() {
		return companyGstNo;
	}
	public void setCompanyGstNo(String companyGstNo) {
		this.companyGstNo = companyGstNo;
	}
	public String getCompanyRating() {
		return companyRating;
	}
	public void setCompanyRating(String companyRating) {
		this.companyRating = companyRating;
	}
	
	public String toString()
	{
		return "\nC_Id: "+companyId+"\nC_Name: "+companyName+"\nC_HeadQuarter: "+headQuarter+"\nCEO: "+companyCeoName+"\nServices: "+companyServices+"\nGST_No: "+companyGstNo+"\nRating: "+companyRating+"\n\n\n";
	}
}
