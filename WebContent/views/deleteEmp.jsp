<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<body>
     
	<div class="container">
	<form action="${pageContext.request.contextPath}/EmployeeController" >
		Enter name <input type="text" name="name"> 
		<button class="btn btn-primary" type="submit" >Delete</button>
</form> 
	</div>

</body>
</html>