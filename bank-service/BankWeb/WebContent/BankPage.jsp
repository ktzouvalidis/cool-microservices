<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%-- <%@ page import="domains.*" %> --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank Page</title>
</head>
<body bgcolor="#99e6ff">
	<h1>Hello, welcome to this awesome bank</h1>
	<form action="BankController" method="post">
		Insert card credentials:
		<input type="number" name="cardNumber">
		<br>
		<br>
		Insert CVC number:
		<input type="number" name="cvcCode">
		<br>
		<br>
		<input type ="submit" value="Submit card info">
	</form>
	
	<%String serviceString = (String)request.getAttribute("out"); %>
	<%= (serviceString!=null)?serviceString:"If connection to Bank Microservice works, you will get message here" %>

</body>
</html>