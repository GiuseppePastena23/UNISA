package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/** Servlet that prints per-client access counts.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on servlets, JSP, Struts, JSF, Ajax, GWT, and Java</a>.
 */

@WebServlet("/client-access-counts")
public class ClientAccessCounts extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    String countString =
      CookieUtilities.getCookieValue(request,
                                     "accessCount",
                                     "1");
    int count = 1;
    try {
      count = Integer.parseInt(countString);
    } catch(NumberFormatException nfe) { }
    LongLivedCookie c =
      new LongLivedCookie("accessCount",
                          String.valueOf(count+1));
    response.addCookie(c);
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Access Count Servlet";
    String docType =
      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      "Transitional//EN\">\n";
    out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<CENTER>\n" +
                "<H1>" + title + "</H1>\n" +
                "<H2>This is visit number " +
                count + " by this browser.</H2>\n" +
                "</CENTER></BODY></HTML>");
  }
}
