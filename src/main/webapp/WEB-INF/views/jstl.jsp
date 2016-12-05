<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Enumeration"%>
<%@ page import="java.io.*,java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>JSTL</h4>
	<%
		out.println("Your address is " + request.getRemoteAddr());
	%>
	<!-- jsp表达式 -->
	<h4>今天的日期是:<%= (new java.util.Date()).toLocaleString() %></h4>
	<!-- jsp变量 -->
	<%! int day=3; %>
	<%
		out.println(day);
	%>
	<h2>Http请求头</h2>
	<table width="100%" border="1" align="center">
	<tr bgcolor="#949494">
		<th>Header Name</th><th>Header Value</th>
	</tr>
	<%
		Enumeration headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String paraName = (String)headerNames.nextElement();
			out.println("<tr><td>"+paraName+"</td>\n");
			String paraValue = request.getHeader(paraName);
			out.println("<td>"+paraValue+"</td></tr>\n");
		}
	%>
	</table>
	<h2>页面点击次数</h2>
	<%
		Integer hitCount = (Integer)application.getAttribute("hitCount");
		if(hitCount==null && hitCount == 0){
			out.println("Welcome new comer !!");
			hitCount = 1;
			application.setAttribute("hitCount", hitCount);
		}else{
			out.println("You have visited "+hitCount+" times!");
			hitCount++;
		}
	%>
	
</body>
</html>