package bean;

public class EmployeeBean {
	private NameBean name;
	private CompanyBean company;

	public EmployeeBean(NameBean name, CompanyBean company) {
		setName(name);
		setCompany(company);
	}

	public NameBean getName() {
		return (name);
	}

	public void setName(NameBean newName) {
		name = newName;
	}

	public CompanyBean getCompany() {
		return (company);
	}

	public void setCompany(CompanyBean newCompany) {
		company = newCompany;
	}

}
