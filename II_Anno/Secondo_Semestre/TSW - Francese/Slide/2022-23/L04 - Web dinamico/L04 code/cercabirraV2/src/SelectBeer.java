package com.example.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.BeerExpert;

/**
 * Servlet implementation class SelectBeer
 */
@WebServlet("/SelectBeer")
public class SelectBeer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c = request.getParameter("color");
		
		BeerExpert be = new BeerExpert();
		List<String> result = be.getBrands(c);
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("Beer Selection Advice<br>");
		Iterator<String> it = result.iterator();
		while (it.hasNext()) {
			out.print("<br>try: " + it.next());
		}		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
