package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/** Servlet that says "Welcome aboard" to first-time
 *  visitors and "Welcome back" to repeat visitors.
 *  Also see RepeatVisitor2 for variation that uses
 *  cookie utilities from later in this chapter.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and Java</a>.
 */

@WebServlet("/repeat-visitor")
public class RepeatVisitor extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    boolean newbie = true;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for(Cookie c: cookies) {
        if ((c.getName().equals("repeatVisitor")) &&
            // Could omit test and treat cookie name as a flag
            (c.getValue().equals("yes"))) {
          newbie = false;
          break;
        }
      }
    }
    String title;
    if (newbie) {
      Cookie returnVisitorCookie =
        new Cookie("repeatVisitor", "yes");
      returnVisitorCookie.setMaxAge(60*60*24*365); // 1 year
      response.addCookie(returnVisitorCookie);
      title = "Welcome Aboard";
    } else {
      title = "Welcome Back";
    }
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +
                "</BODY></HTML>");
  }
}
