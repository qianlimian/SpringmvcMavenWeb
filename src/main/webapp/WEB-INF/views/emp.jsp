<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 自定义类型转换器 -->
	<!-- GG-gg@sina.com-0-105 -->
	<form action="${pageContext.request.contextPath }/testConverter" method="post">
		Employee:<input type="text" name="employee">
		<br><br>
		<input type="submit" value="submit">
	</form>
	<!-- 这里的modelAttribute是必须要有的，若没有会到请求域中查找键为command的的键值对，找不到会报错 -->
	<!-- action路径是一个绝对路径，如果是相对路径在不同的请求页面可能会有所不同 -->
	<form:form action="${pageContext.request.contextPath }/emp" method="post" modelAttribute="employee"> 
		<c:if test="${employee.id == null }">
			LastName:<form:input path="lastName"/>
		</c:if>
		<br><br>
		<c:if test="${employee.id != null }">
			<form:hidden path="id"/>
			<input type="hidden" name="_method" value="PUT">
		</c:if>
		Email:<form:input path="email"/>
		<%
			Map<String,String> genders = new HashMap<String,String>();
			genders.put("0","Female");
			genders.put("1","Male");
			request.setAttribute("genders", genders);
		%>
		<br><br>
		<!-- genders和departments都是放到请求域中的HashMap -->
		Gender:<form:radiobuttons path="gender" items="${genders }"/>
		<br><br>
		<!-- 如果form的表单项小于实际的对象属性，是否可以？？ -->
		<!-- 可以，在新增employee的时候，就没有id这个选项 -->
		Department:<form:select path="department.id" items="${departments }" itemLabel="departmentName" itemValue="id"></form:select>
		<br><br>
		<input type="submit" value="submit">
	</form:form>
</body>
</html>