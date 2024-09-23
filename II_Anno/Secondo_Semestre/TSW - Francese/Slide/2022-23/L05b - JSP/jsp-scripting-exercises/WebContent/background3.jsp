<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML><HEAD><TITLE>User-Specified Background</TITLE></HEAD>
<%! private String previousColor = "WHITE"; %>
<%-- Due to race conditions you cannot directly output 
     previousColor. You need a local variable. --%>
<% String bgColor = request.getParameter("bgColor");
   if ((bgColor != null) && (!bgColor.trim().equals(""))) {
     previousColor = bgColor;
   } else {
     bgColor = previousColor;
   }
%>
<BODY BGCOLOR="<%=bgColor%>">
<CENTER> <!-- Headings in two colors in case bg is black. --> 
<H1>User-Specified Background</H1>
<H1><FONT COLOR="WHITE">User-Specified Background</FONT></H1>
</CENTER>
</BODY></HTML>