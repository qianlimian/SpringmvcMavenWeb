<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-2.2.3.min.js"></script>
<!-- ajax的post请求 -->
<script type="text/javascript">
	$(function(){
		$("#testJson").click(function(){
			var url = this.href;
			var args = {};
			$.post(url,args,function(data){
				for(var i=0;i<data.length;i++){
					var id = data[i].id;
					var lastName = data[i].lastName;
					alert(id+" : "+lastName);
				}
			});
			return false;
		});
	})
</script>
</script>
</head>

<body>
	<a href="testJson" id="testJson">testJson</a>
	<br><br>
	<form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
		File:<input type="file" name="file">
		<br>
		Desc:<input type="text" name="desc">
		<br>
		<input type="submit" value="submit">
	</form>
</body>
</html>