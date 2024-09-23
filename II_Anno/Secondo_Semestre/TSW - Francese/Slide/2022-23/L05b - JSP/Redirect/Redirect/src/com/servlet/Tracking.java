package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Tracking")
public class Tracking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> logs = (List<String>)request.getSession().getAttribute("logs");
		if(logs == null) {
			logs = new ArrayList<String>();
		}
		request.getSession().setAttribute("logs", logs);
			
		String url = request.getParameter("url");
		if(url != null && !url.equals("")) {
			String q = request.getParameter("q");
			
			if(q != null && !q.equals("")) {
				q = q.replace(" ", "+");
				q = "?q=" + q;
			} else {
				q = "";
			}
			
			logs.add(url+q);
			response.sendRedirect(url+q);
			return;
		}
		
		request.setAttribute("logs", logs);
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/tracking.jsp");
        dispatcher.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
