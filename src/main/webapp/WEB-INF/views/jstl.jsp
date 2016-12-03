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
	
	<h2>JSP　Session</h2>
	<%
		Date createTime = new Date(session.getCreationTime());
		Date lastAccessTime = new Date(session.getLastAccessedTime());
		String title = "再次访问网站";
		Integer visitCount = new Integer(0);
		String visitCountKey = new String("visitCount");
		String userIdKey = new String("userId");
		String userId = new String("abcd");
		
		if(session.isNew()){
			title="初次访问！";
			session.setAttribute(visitCountKey, visitCount);
			session.setAttribute(userIdKey, userId);
		}else{
			visitCount = (Integer)session.getAttribute(visitCountKey);
			visitCount++;
			userId = (String)session.getAttribute(userIdKey);
			session.setAttribute(visitCountKey, visitCount);
		}
	%>
	<table border="1" align="center">
		<tr>
			<th>Session信息</th>
			<th>值</th>>
		</tr>
		<tr>
			<td>id</td>
			<td><% out.println(session.getId()); %>></td>
		</tr>
		<tr>
			<td>创建时间</td>
			<td><% out.println(session.getCreationTime()); %>></td>
		</tr>
		<tr>
			<td>最后访问时间</td>
			<td><% out.println(session.getLastAccessedTime()); %></td>
		</tr>
		<tr>
			<td>用户 ID</td>
			<td><% out.println(session.getAttribute(userIdKey)); %></td>
		</tr>
		<tr>
			<td>访问次数</td>
			<td><% out.println(session.getAttribute(visitCountKey)); %></td>
		</tr>
	</table>
</body>
</html>