package com.example.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.model.Calculator;

@WebServlet("/AddObject")
public class AddObject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		synchronized (session) {
			session.setAttribute("calcsession", new Calculator());
		}
		
		Integer number = 2 + (int)(Math.random() * 10);
		request.setAttribute("calcsessionnumber", number);
		
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
