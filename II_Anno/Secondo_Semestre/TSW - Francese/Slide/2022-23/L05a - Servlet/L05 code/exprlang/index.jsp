<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language</title>
</head>
<body>
	<h2>Accessing Bean Properties</h2>
	<ul>
		<li><b>First Name:</b> ${employee.name.firstName}
		<li><b>Last Name:</b> ${employee.name.lastName}
		<li><b>Company Name:</b> ${employee.company.companyName}
		<li><b>Company Business:</b> ${employee.company.business}
	</ul>

	<h2>Accessing Collections</h2>
	<ul>
		<li>${first[0]} ${last[0]} (${company["Ellison"]})
		<li>${first[1]} ${last["1"]} (${company["Gates"]})
		<li>${first[2]} ${last[2]} (${company["McNealy"]})
	</ul>

	<h2>Using Implicit Objects</h2>
	<ul>
		<li><b>test Request Parameter:</b> ${param.test}
		<li><b>User-Agent Header:</b> ${header["User-Agent"]}
		<li><b>JSESSIONID Cookie Value:</b> ${cookie.JSESSIONID.value}
		<li><b>Server:</b> ${pageContext.servletContext.serverInfo}
		<li><b>pafeContext:</b> ${pageContext.session.id}
		<li><b>header</b> ${header["Accept"]}
		<li><b>headerValues</b> ${headerValues.Accept[0]}
		<li><b>header:</b> ${header["Accept-Encoding"]} 
		<li><b>requestScope:</b> ${requestScope.employee}
		<li><b>requestScope:</b> ${requestScope.employee.name.firstName}
		
	</ul>

<table BORDER=1>
<tr>
	<th COLSPAN=2>Arithmetic Operators</th>
	<th COLSPAN=2>Relational Operators</th>
</tr>
<tr>
	<th>Expression</th>
	<th>Result</th>
	<th>Expression</th>
	<th>Result</th>
</tr> 
<tr ALIGN="CENTER">
	<td>\${3+2-1}</td><td>${3+2-1}</td> <%-- Addition/Subtraction --%>
	<td>\${1&lt;2}</td><td>${1<2}</td> <%-- Numerical comparison --%>
</tr>
<tr ALIGN="CENTER">
	<td>\${"1"+2}</td><td>${"1"+2}</td> <%-- String conversion --%>
	<td>\${"a"&lt;"b"}<TD>${"a"<"b"}</td> <%-- Lexical comparison --%> 
</tr>
<tr ALIGN="CENTER">
	<td>\${1 + 2*3 + 3/4}<TD>${1 + 2*3 + 3/4}</td> <%-- Mult/Div --%>
	<td>\${2/3 &gt;= 3/2}<TD>${2/3 >= 3/2}</td> <%-- >= --%> 
</tr>
<tr ALIGN="CENTER">
	<td>\${3%2}<TD>${3%2}</TD> <%-- Modulo --%>
	<td>\${3/4 == 0.75}<TD>${3/4 == 0.75}</TD> <%-- Numeric = --%> 
</tr>
<tr ALIGN="CENTER">
	<td>\${(8 div 2) mod 3}</td><td>${(8 % 2) mod 3}</td> <%-- div and mod are alternatives to / and % --%>
	<td>\${null == "test"}</td><td>${null == 'test'}</td> <%-- Compares with "equals" but returns false for null --%>
</tr>
<tr>
	<th COLSPAN=2>Logical Operators</th>
	<th COLSPAN=2>empty Operator</th>
</tr>
<tr>
	<th>Expression</th>
	<th>Result</th>
	<th>Expression</th>
	<th>Result</th>
</tr>
<tr ALIGN="CENTER">
	<td>\${(1&lt;2) &amp;&amp; (4&lt;3)}</td><td>${(1<2) && (4<3)}</td> <%--AND--%>
	<td>\${empty ""}</td><td>${empty ""}</td> <%-- Empty string --%> 
</tr>	
<tr ALIGN="CENTER">
	<td>\${(1&lt;2) || (4&lt;3)}</td><td>${(1<2) || (4<3)}</td> <%--OR--%>
	<td>\${empty null}</td><td>${empty null}</td> <%-- null --%> 
</tr>	
<tr ALIGN="CENTER">
	<td>\${!(1&lt;2)}</td><td>${!(1<2)}</td> <%-- NOT --%>
	<td>\${empty param.blah}</td><td>${empty param.blah}</td> <%-- Handles null or empty string in request param --%> 
</tr>	
</table>

</body>
</html>