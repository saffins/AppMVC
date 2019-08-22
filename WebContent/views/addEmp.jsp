<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 
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
	<form action="${pageContext.request.contextPath}/EmployeeController" method="post">
		Enter name <input type="text" name="name" value="${employee.name}"><br /> 
		Enter DOB <input type="date" name="dob" value="${employee.dob}"><br />
		 Designation<input type="text"
			name="designation" value="${employee.department}">
			<input type="hidden" value="${employee.id}" name="id"/>
		<button class="btn btn-primary" type="submit" >Save</button>
</form> 
	</div>

</body>
</html>