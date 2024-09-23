<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Action:</h3>
	<jsp:useBean id="myBean" class="com.example.model.HelloBean"/>
	<jsp:setProperty name="myBean" property="nameProp" value="Michele"/>
	Hello, <jsp:getProperty name="myBean" property="nameProp"/>!
</body>
</html>