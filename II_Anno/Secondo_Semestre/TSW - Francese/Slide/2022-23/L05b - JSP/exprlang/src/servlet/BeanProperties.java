package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CompanyBean;
import bean.EmployeeBean;
import bean.NameBean;

@WebServlet("/BeanProperties")
public class BeanProperties extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BeanProperties() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NameBean name = new NameBean("Rita", "Francese");
		CompanyBean company = new CompanyBean("Unisa.it", "Tecnologie Sviluppo Web");

		EmployeeBean employee = new EmployeeBean(name, company);
		request.setAttribute("employee", employee);

		String[] firstNames = { "Bill", "Scott", "Larry" };
		
		ArrayList<String> lastNames = new ArrayList<String>();
		lastNames.add("Ellison");
		lastNames.add("Gates");
		lastNames.add("McNealy");
		
		HashMap<String, String> companyNames = new HashMap<String, String>();
		companyNames.put("Ellison", "Sun");
		companyNames.put("Gates", "Oracle");
		companyNames.put("McNealy", "Microsoft");
		
		request.setAttribute("first", firstNames);
		request.setAttribute("last", lastNames);
		request.setAttribute("company", companyNames);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");

		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
