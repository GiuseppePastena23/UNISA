

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletResponse")
public class ServletResponse extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		

		response.setContentType("text/xml");
		
		StringBuffer packed = new StringBuffer();
		packed.append("<info>");
				
		String param = (String)request.getParameter("param");
		if(param != null) {
			packed.append("<person>");
			packed.append(param+" "+ new Date().toString());
			packed.append("</person>");
		}
	
		packed.append("</info>");
		
		try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {}
		
		response.getWriter().write(packed.toString());		
	}
	
	
	private static final long serialVersionUID = 1L;
    
    public ServletResponse() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}	

}
