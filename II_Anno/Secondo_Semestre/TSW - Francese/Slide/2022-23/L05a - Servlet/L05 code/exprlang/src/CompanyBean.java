package bean;

public class CompanyBean {
	private String companyName;
	private String business;

	public CompanyBean(String companyName, String business) {
		setCompanyName(companyName);
		setBusiness(business);
	}

	public String getCompanyName() {
		return (companyName);
	}

	public void setCompanyName(String newCompanyName) {
		companyName = newCompanyName;
	}

	public String getBusiness() {
		return (business);
	}

	public void setBusiness(String newBusiness) { 
		business = newBusiness;
	}
}
