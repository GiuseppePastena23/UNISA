package com.example.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/showsession")
public class ShowSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void writeHeaders(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<h2>Header list</h2>");
		out.println("<ul>");
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			
			out.println("<li>"+headerName+" : "+headerValue+"</li>");
		}
		
		out.println("</ul>");
	}	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String heading;
		String itemList = "";
		HttpSession session = request.getSession();
	
		synchronized (session) {
			Integer accessCount = (Integer) session.getAttribute("accessCount");
			if(accessCount == null) {
				accessCount = 1;
				heading = "Welcome, Newcomer ("+accessCount+")";			
			} else {
				accessCount = accessCount + 1;
				heading = "Welcome Back ("+accessCount+")";
			}
			session.setAttribute("accessCount", accessCount);
			
			List<String> items = (List<String>) session.getAttribute("items");
			if(items == null) {
				items = new ArrayList<String>();
			}
			String item = request.getParameter("item");
			if(item != null) {
				items.add(item);
			}
			session.setAttribute("items", items);
			
			for(String s : items) {
				itemList += s +"<br>";  
			}
		}
		
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head><title>Session tracking</title></head>");
		out.println("<body>");
		
		writeHeaders(request, response);
		
		out.println("<h2>"+heading+"</h2>");
		out.println("<br>");
		String eurl = response.encodeURL("showsession");
			
		out.println("List:<br>"+ itemList);
		
		out.println("<br>");
		out.println("<form method='get' action='"+eurl+"'>");
		out.println("Item:");
		out.println("<input type='text' name='item' required placeholder='item....'>");
		out.println("<input type='submit' value='Add'>");
		out.println("</form>");
		
		out.println("<br>");
		
		out.println("<a href='"+eurl+"'>Refresh</a>");
		
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
