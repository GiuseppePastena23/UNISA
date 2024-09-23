package it.unisa.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AccessCount")
public class AccessCount extends HttpServlet {
	private static final long serialVersionUID = 1L;


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
			
			String link = response.encodeURL("AccessCount");

			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE html>" 
			+ "<html>" 
			+ "<head><title>Session Tracking Example</title></head>" 
			+ "<body>"
			+ "<h1>" + heading + "</h1>" 
			+ "<h2>Information on Your Session:</h2>" 
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
			+ "<br>Link: " + link
			+ "<br><a href='"+ link +"'>Refresh</a>"
			+ "</body></html>");	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
