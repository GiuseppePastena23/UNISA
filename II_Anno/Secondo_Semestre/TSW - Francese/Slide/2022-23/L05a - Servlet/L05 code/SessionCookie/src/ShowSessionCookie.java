package com.example.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.utils.LongLivedCookie;


@WebServlet("/showsessioncookie")
public class ShowSessionCookie extends HttpServlet {
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
	
	private String getCookieValue(HttpServletRequest request, 
			String cookieName, String defaultValue) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookieName.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return defaultValue;
	}	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String countString = getCookieValue(request,"accessCount", "1");
		int count = 1;
		try {
			count = Integer.parseInt(countString);
		} catch(NumberFormatException e) {}
		
		LongLivedCookie c = 
				new LongLivedCookie("accessCount", String.valueOf(count + 1));
		response.addCookie(c);
		
		String heading;
		if(count == 1) {
			heading = "Welcome, Newcomer ("+count+")";
		} else {
			heading = "Welcome Back ("+count+")";
		}
		
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head><title>Session tracking</title></head>");
		out.println("<body>");
		
		writeHeaders(request, response);
		
		out.println("<h2>"+heading+"</h2>");
		out.println("</body>");
		out.println("</html>");
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
