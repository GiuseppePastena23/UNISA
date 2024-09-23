package com.logic;

import java.io.IOException;
import java.util.List;

import com.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SelectBeer")
public class SelectBeer extends HttpServlet {

	public SelectBeer() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String c = request.getParameter("color");
		BeerExpert be = new BeerExpert();
		
		if(be.isValid(c)) {
			
			List<String> result = be.getBrands(c);		
			request.setAttribute("result", result);	
			
			List<String> colors = be.getColors();
			request.setAttribute("colors", colors);	
		} 
		
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
