<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.CurrentTimeBean"%>
<!DOCTYPE html>
<jsp:useBean id="time3" class="bean.CurrentTimeBean">
	<jsp:setProperty name="time3" property="hours" value="3"/>
</jsp:useBean>
<html>
<head>
<title>Bean</title>
</head>
<body>
<p>Sono le ore
	<jsp:getProperty property="hours" name="time3"/> e
	<jsp:getProperty property="minutes" name="time3"/> minuti.</p>
</body>
</html>