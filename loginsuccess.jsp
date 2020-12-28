<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	You have Successfully logged in your email is <%=session.getAttribute("sesname") %><br/>
	<a href="index.html">LogOut</a> 
</body>
</html>