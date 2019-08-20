<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee</title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<body>

	<div class="container">
	<form action="${pageContext.request.contextPath}/EmployeeController" method="POST">
		Enter name <input type="text" name="name"><br /> Enter DOB <input
			type="date" name="dob"><br /> Designation<input type="text"
			name="designation">
		<button class="btn btn-primary" type="submit" >Save</button>
</form> 
	</div>

</body>
</html>