<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="emp" method="post" modelAttribute="employee"> 
		LastName:<form:input path="lastName"/>
		<br><br>
		Email:<form:input path="email"/>
		<%
			Map<String,String> genders = new HashMap<String,String>();
			genders.put("0","Female");
			genders.put("1","Male");
			request.setAttribute("genders", genders);
		%>
		<br><br>
		Gender:<form:radiobuttons path="gender" items="${genders }"/>
		<br><br>
		Department:<form:select path="department.id" items="${departments }" itemLabel="departmentName" itemValue="id"></form:select>
	</form:form>
</body>
</html>