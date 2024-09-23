<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Collecting Beer Info</title>
<link href="result.css" rel="stylesheet">
</head>
<body>
	<h1 align="left">Beer Selection</h1>
	
	<% 
		String color =  (String) request.getParameter("color");
	
		List<?> colors =  (List<?>) request.getAttribute("colors");
	    if(colors != null) {
	%> 		
	<form action="SelectBeer" method="get">
		Select beer characteristics
		<select name="color">
			<%    	
			Iterator<?> cit = colors.iterator();
			while(cit.hasNext()) {
				String value = cit.next().toString();
			
				if(value.equals(color)) {
			%>
	   			<option value="<%= value%>" selected><%= value%></option>
			<%
				} else {
					%>
		   			<option value="<%= value%>"><%= value%></option>
				<%		
					}
			}
			%>
		</select>
		<input type="submit">
	</form>
	<%
	    }

		List<?> brands =  (List<?>) request.getAttribute("result");
	    if(brands != null) {
	%>    	
	  	<h2>Beer Recommendations (JSP) for <%= color%></h2>
	<%    	
	Iterator<?> it = brands.iterator();
	while(it.hasNext()) {
	%>
	   try: <%= it.next()%><br>
	<%
						}
	    }
	%>

