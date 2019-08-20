<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list of Employees</title>
</head>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css"
rel = "stylesheet" />

<body>



<div class ="container">

<button class="btn btn-primary" onclick="window.location.href='views/addEmp.jsp'">Add Employee</button>

	<table border="1" class="table table-striped table-bordered">
		<tr class="thead-dark">
			<th>name</th>
			<th>dob</th>
			<th>department</th>



		</tr>

		<c:forEach items="${list}" var="employee">

			<tr>

				<td>${employee.name}</td>
				<td>${employee.dob}</td>
				<td>${employee.department}</td>

			</tr>

		</c:forEach>

	</table>
</div>
</body>
</html>