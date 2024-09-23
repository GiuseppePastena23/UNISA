<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UseBean</title>
</head>
<body>

<h3>Compute Factorial</h3>

<%
  int localnumber = 2 + (int)(Math.random() * 10);
%>
<jsp:useBean id="calc" class="com.example.model.Calculator">
	<jsp:setProperty name="calc" property="fact" value="<%=localnumber %>" />
</jsp:useBean>  
Factorial of <jsp:getProperty name="calc" property="fact" /> 
is <jsp:getProperty name="calc" property="factorial" /> (local).   
<br>

<jsp:useBean id="calcsession" class="com.example.model.Calculator" 
scope="session" />
Factorial of <jsp:getProperty name="calcsession" property="fact" /> 
is <jsp:getProperty name="calcsession" property="factorial" /> (random object from session).  
<br>

<%
  Integer numberRequest = (Integer)request.getAttribute("calcsessionnumber");
  if(numberRequest == null) {
	  numberRequest = 1;
  }
%>
<jsp:useBean id="calcrequest" class="com.example.model.Calculator" scope="request">
	<jsp:setProperty name="calcrequest" property="fact" value="<%=numberRequest%>" />
</jsp:useBean>
Factorial of <jsp:getProperty name="calcrequest" property="fact" /> 
is <jsp:getProperty name="calcrequest" property="factorial" /> (random number from request).  
<br>
<br>

<form name="putinsession" action="AddObject">
<input type="submit" value="Generate factorials">
</form>

</body>
</html>