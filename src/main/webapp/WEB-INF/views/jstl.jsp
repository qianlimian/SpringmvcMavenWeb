<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Enumeration"%>
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
	<h2>Response自动刷新</h2>
	<%
		//response.setIntHeader("Refresh", 1);
		Calendar calendar = new GregorianCalendar();
		String am_pm;
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		if(calendar.get(Calendar.AM_PM)==0){
			am_pm = "AM";
		}else{
			am_pm = "PM";
		}
		String CT = hour+":"+minute+":"+second+":"+" "+am_pm;
		out.println(CT);
	%>
	<h2>获取GET请求的参数</h2>
	<h3><%= request.getParameter("name") %></h3>
	<h3><%= request.getParameter("age") %></h3>
</body>
</html>