

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CurrentTimeBean;

@WebServlet("/GenerateTime")
public class GenerateTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GenerateTime() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CurrentTimeBean ctb = new CurrentTimeBean();
		ctb.setHours(15);
		ctb.setMinutes(16);
		
		request.getSession().setAttribute("time2", ctb);
		
		RequestDispatcher dispatcher = 
				getServletContext().
				getRequestDispatcher("/temp2.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
