package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowSession() {
        super();
     }

    private void writeHeaders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
    	
    	out.println("<table border='1'>"
		+ "<tr>" 
        + "<th>Header Name<th>Header Value");
		
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
		  String headerName = headerNames.nextElement();
		  out.println("<tr><td>" + headerName + "</td>");
		  out.println("<td>" + request.getHeader(headerName) + "</td>");
		}
		out.println("</table>");			
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		synchronized (session) {
			String heading;
			Integer accessCount = (Integer) session.getAttribute("accessCount");
			if (accessCount == null) {
				accessCount = 0;
				heading = "Welcome, Newcomer";
			} else {
				heading = "Welcome Back";
				accessCount = accessCount + 1;
			}
			
			session.setAttribute("accessCount", accessCount);

			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>" 
			+ "<html>" 
			+ "<head><title>Session Tracking Example</title></head>" 
			+ "<body>"
			+ "<h1>" + heading + "</h1>");
			
			writeHeaders(request, response);
			
			out.println("<h2>Information on Your Session:</h2>" 
			+ "<table border='1'>"
			+ "<tr>" 
			+ "<th>Info Type</th><th>Value</th>" 
			+ "</tr><tr>" 
			+ "<td>ID</td><td>" + session.getId() + "</td>" 
			+ "</tr><tr>" 
			+ "<td>Creation Time</td><td>" + new Date(session.getCreationTime()) + "</td>" 
			+ "</tr><tr>"
			+ "<td>Time of Last Access</td><td>" + new Date(session.getLastAccessedTime()) + "</td>"
			+ "</tr><tr>" 
			+ "<td>Number of Previous Accesses</td><td>" + accessCount + "</td>" 
			+ "</table>"
			+ "</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet(request, response);
		response.setContentType("text/html");

		HttpSession session = request.getSession();

		synchronized (session) {
			@SuppressWarnings("unchecked")
			List<String> previousItems = (List<String>) session.getAttribute("previousItems");
			if (previousItems == null) {
				previousItems = new ArrayList<String>();
			}
			String newItem = request.getParameter("newItem");
			if (newItem != null) {
				previousItems.add(newItem);
			}
			session.setAttribute("previousItems", previousItems);
			
			String sessionID = request.getParameter("session");
			
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>"  
					+ "<html>" 
					+ "<head><title>Session Tracking Example</title></head>" 
					+ "<body>");
			
			writeHeaders(request, response);
			
					out.println("<h1>Access to the Session</h1>"
					+ "<h2>List of items:</h2>");			
					
		    if (previousItems.size() == 0) {
		      out.println("<i>No items</i>");
		    } else {
		      out.println("<ul>");
		      for(String item: previousItems) {
		        out.println("<li>" + item + "</li>");
		      }
		      out.println("</ul>");
		    }
		    
			if (sessionID != null) {
				out.println("ID: "+sessionID+ "<br>");
			}
		    
		    out.println("</body></html>");	
		}	
	}
}
