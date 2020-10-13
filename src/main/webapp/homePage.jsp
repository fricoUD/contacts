<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="shortcut icon" href="https://www.gstatic.com/images/branding/product/1x/contacts_48dp.png" type="image/x-icon" />.
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contacts</title>
</head>
<body>
    <h1>Contacts</h1>
	<form method="post" action="Main2"></form>

	<table>
		
			</tr>
<% request.setAttribute("read", "this"); %>
<c:out value="${table }"></c:out>
	</table>
</body>
</html>