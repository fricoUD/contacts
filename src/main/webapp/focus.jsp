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

input:focus, textarea:focus, select:focus {
	outline: none;
}
</style>
<body>
	<div class="container">
		<form action="Main2" method="post">
			<label for="name">Name</label> <input value="${toEdit.getName()}"
				type="text" name="name" readonly> <br> <label
				for="surname">Surname</label> <input value="${toEdit.getSurname()}"
				type="text" name="surname" readonly> <br> <label
				for="number">Number</label> <input value="${toEdit.getNumber()}"
				type="text" name="number" readonly> <br> <label
				for="sex">Gender</label> <input value="${toEdit.getSex()}"
				type="text" name="sex" readonly>
			<div>
				<br>
				<button type="submit" name="home" value="pressed">Home</button>
			</div>
		</form>
	</div>
</body>
</html>