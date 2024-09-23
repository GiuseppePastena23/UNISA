package it.unisa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class REchoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public REchoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		Enumeration<String> parameterNames = request.getParameterNames();

		while (parameterNames.hasMoreElements()) {

			String paramName = parameterNames.nextElement();
			out.write(paramName);
			out.write(" = \n");

			String[] paramValues = request.getParameterValues(paramName);
			for (int i = 0; i < paramValues.length; i++) {
				String paramValue = paramValues[i];
				out.write("\t" + paramValue);
				out.write("\n");
			}
			out.write("\n");

		}

		out.close();	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		InputStream is = request.getInputStream();
		
		BufferedReader in = new BufferedReader(
				new InputStreamReader(is));
		
		out.println("<html><body>");
		out.println("Contenuto del body del pacchetto: ");
		String line;
		while((line = in.readLine()) != null) 
			out.println(line);
		
		out.println("</body></html>");		
	}

}
