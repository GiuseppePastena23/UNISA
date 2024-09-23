<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Session Tracking Example</title>
</head>
<body>
<h1>Access to the Session Information</h1>
<h4>Check GET method (counter):</h4>
<form method="get" action="ShowSession">
<input type="submit" value="Increment">
</form>

<h4>Check POST method (list of items):</h4>
<form method="post" action="ShowSession">
<input type="hidden" name="session" value="<%=request.getSession().getId()%>">
<label for="newItem">New item:</label><input type="text" name="newItem" required placeholder="item..."><br>

<input type="submit" value="Add">
</form>

</body>
</html>