<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th>ID</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Department</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${requestScope.employees }" var="emp">
		<tr>
		<td>${emp.id }</td>
		<td>${emp.lastName }</td>
		<td>${emp.email }</td>
		<td>${emp.gender == 0 ? Female : Male }</td>
		<td>${emp.department.departmentName }</td>
		<td><a href="#">Edit</a></td>
		<td><a href="#">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>