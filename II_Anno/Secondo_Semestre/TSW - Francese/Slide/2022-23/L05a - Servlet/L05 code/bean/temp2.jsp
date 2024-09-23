<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="bean.CurrentTimeBean"%>
<!DOCTYPE html>
<jsp:useBean id="time" class="bean.CurrentTimeBean"/>
<jsp:useBean id="time2" class="bean.CurrentTimeBean" scope="session"/>
<html>
<head>
<title>Bean</title>
</head>
<body>
<p>Sono le ore
	<jsp:getProperty property="hours" name="time"/> e
	<jsp:getProperty property="minutes" name="time"/> minuti.</p>

<br>
<br>
<p>Sono le ore
	<jsp:getProperty property="hours" name="time2"/> e
	<jsp:getProperty property="minutes" name="time2"/> minuti.</p>

</body>
</html>