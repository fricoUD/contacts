<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="shortcut icon"
	href="https://www.gstatic.com/images/branding/product/1x/contacts_48dp.png"
	type="image/x-icon" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>

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
	background-color: lightgrey;
}

.content {
	display: none;
}

.buttonHide:hover .content {
	display: contents;
}

#tableWrapper {
	height: 30em;
	overflow-y: scroll;
}

#myHeading img {
	float: left;
	margin-right: 10px;
	position: relative;
	top: 0px;
}
</style>

<meta charset="ISO-8859-1">
<title>Contacts</title>
</head>
<body>
	<div id="myHeading">
		<img
			src="https://www.gstatic.com/images/branding/product/1x/contacts_48dp.png" />
		<h1>Contacts</h1>
	</div>
	<form method="post" action="Main2" class="submit-button">
		<button type="submit" value="Add" name="buttonPressed" class="fa fa-user-plus"></button>
	</form>
	<form method="get" action="Main2"></form>
	<div id="tableWrapper">
		<table>
			<c:forEach items="${starredTable.keySet()}" var="current">
				<tr class="info buttonHide">
					<form id="${current}" method="get" action="Main2">
						<input type="hidden" name="edit" value="${current}"><input
							type="hidden" name="buttonPressed" value="Show">
					</form>
					<td onclick="send('${current}')"><c:out
							value="${starredTable.get(current).getName()}" /> <c:out
							value="${starredTable.get(current).getSurname()}" />
					<td>
						<form method="post" action="Main2" class="submit-button"
							style="margin-bottom: 0; text-align: -webkit-right;">
							<button type="submit" value="Edit" name="buttonPressed"
								class="content">
								<i class="fa fa-edit fa-lg icon"></i>
							</button>
							<button type="submit" value="Delete" name="buttonPressed"
								class="content">
								<i class="fa fa-trash fa-lg icon"></i>
							</button>
							<button type="submit" value="Fav"
								onclick="window.location.reload()" name="buttonPressed"
								class="content">
								<i class="fa fa-star fa-lg icon"></i>
							</button>
							<input type="hidden" value="${current}" name="edit">
						</form>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form method="get" action="Main2"></form>
	<h2>Normal bois</h2>
	<div id="tableWrapper">
		<table>
			<c:forEach items="${contactsTable.keySet()}" var="current">
				<tr class="info buttonHide">
					<form id="${current}" method="get" action="Main2">
						<input type="hidden" name="edit" value="${current}"><input
							type="hidden" name="buttonPressed" value="Show">
					</form>
					<td onclick="send('${current}')"><c:out
							value="${contactsTable.get(current).getName()}" /> <c:out
							value="${contactsTable.get(current).getSurname()}" />
					<td>
						<form method="post" action="Main2" class="submit-button"
							style="margin-bottom: 0; text-align: -webkit-right;">
							<button type="submit" value="Edit" name="buttonPressed"
								class="content">
								<i class="fa fa-edit fa-lg icon"></i>
							</button>
							<button type="submit" value="Delete" name="buttonPressed"
								class="content">
								<i class="fa fa-trash fa-lg icon"></i>
							</button>
							<button type="submit" value="Fav"
								onclick="window.location.reload()" name="buttonPressed"
								class="content">
								<i class="fa fa-star-o fa-lg icon"></i>
							</button>
							<input type="hidden" value="${current}" name="edit">
						</form>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script>
		function addButton(x) {
			return $.ajax({
				type : "POST",
				url : "Main2",
				data : {
					"buttonPressed" : "Add"
				}
			});
		}
	</script>
	<script type="text/javascript">
		function send(x) {
			document.getElementById(x).submit();

		}
	</script>
	</ body>
</html>
