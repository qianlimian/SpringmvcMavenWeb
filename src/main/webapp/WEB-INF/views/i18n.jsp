<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="script/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#message").click(function(){
			var url = this.href;
			var args = {};
			$.post(url,args,function(data){
				//这里的data会出现乱码
				alert(escape(data));
			});
			return false;
		});
	})
</script>
<title>Insert title here</title>
</head>
<body>
	<fmt:message key="i18n.username"></fmt:message>
	<br>
	<fmt:message key="i18n.password"></fmt:message>
	<br>
	<a href="resourceBundleMessageSource" id="message">resourceBundleMessageSource</a><br>
	<button id="button">button</button>
</body>
</html>