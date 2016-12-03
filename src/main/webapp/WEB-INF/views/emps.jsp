<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var href = $(this).attr("href");
			$("form").attr("action",href).submit();
			return false;
		});
	})
</script>
</head>
<body>
	<form action="" method="POST">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>
	<table border="1" align="center" cellpadding="10" cellspacing="0">
		<tr>
			<th>ID</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Department</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${employees }" var="emp">
		<tr>
		<td>${emp.id }</td>
		<td>${emp.lastName }</td>
		<td>${emp.email }</td>
		<td>${emp.gender == 0 ? "Female" : "Male" }</td>
		<td>${emp.department.departmentName }</td>
		<td><a href="edit/${emp.id }">Edit</a></td>
		<td><a href="delete/${emp.id }" class="delete">Delete</a></td>
		</tr>
		</c:forEach>
		
	</table>
	<br><br>
	<a href="emp">Add Employee</a>
</body>
</html>