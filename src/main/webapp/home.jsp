<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="shortcut icon" href="https://www.gstatic.com/images/branding/product/1x/contacts_48dp.png" type="image/x-icon" />
	<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>

table {
	text-align: left;
	margin-left: auto;
	margin-right: auto;
	width: 35em;
	margin-left: 3em;
}

th, td {
	padding: 5px;
}

.info:hover {
	background-color: lightgrey
}

#myHeading img {
  float:left;
  margin-right:10px;
  position: relative;
  top:0px;
}

</style>

<meta charset="ISO-8859-1">
<title>Contacts</title>
</head>
<body>
	<div id="myHeading">
    <img src="https://www.gstatic.com/images/branding/product/1x/contacts_48dp.png" />
    <h1>Contacts</h1>
</div>
	<form method="post" action="Main2"></form>

	<table>
		<c:forEach items="${table.keySet()}" var="current">
			<tr class="info">
				<td><c:out value="${table.get(current).getName()}" />
					<c:out value="${table.get(current).getSurname()}" />
				<td>
					<form method="post" action="Main2" class="submit-button"
						style="margin-bottom: 0;text-align: -webkit-right;">
						<button type="submit" value="Edit"> <i class="fa fa-edit icon"></i>
						</button>
						<button type="submit" value="Delete"> <i class="fa fa-trash icon"></i>
						</button>
						<input type="hidden"
							value="${current}" name="edit">
					</form>
			</tr>

		</c:forEach>
	</table>
</body>
</html>
