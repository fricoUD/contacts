<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.container {
	width: 30em;
}

.container input {
	width: 100%;
}

body {
	text-align: -webkit-center;
}

form {
	text-align-last: center;
}
</style>
<body>
	<div class="container">
		<form action="Main2" method="post">
			<label for="name">Name</label> <input value="${mario.getName()}"
				type="text" name="name"> <br> <label for="surname">Surname</label>
			<input value="${mario.getSurname()}" type="text" name="surname">
			<br> <label for="number">Number</label> <input
				value="${mario.getNumber()}" type="text" name="number"> <br>
			<label for="sex">Gender</label> <input value="${mario.getSex()}"
				type="text" name="sex"> <input type="hidden"
				value="${mario.getUuid()}" type="text" name="key">
			<div>
				<br>
				<button type="submit" name="home" value="pressed">Home</button>
				<button type="submit" name="apply" value="pressed">Apply</button>
			</div>
		</form>
	</div>
</body>
</html>