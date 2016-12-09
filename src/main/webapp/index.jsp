<html>
<body>
	<a href="crud">CRUD</a>
	<a href="testRedirect">testRedirect</a>
	<br><br>
	<a href="testView">testView</a>
	<form action="testModelAttribute" method="post">
		<input type="hidden" name="id" value="1"> Username:<input
			type="text" name="username" value="tom"> Email:<input
			type="text" name="email" value="tom@sina.com"> Age:<input
			type="text" name="age" value="15"> <input type="submit"
			value="submit">
	</form>
	<br>
	<br>
	<a href="testMap">textMap</a>
	<br />
	<a href="testModelAndView">testModelAndView</a>
	<form action="testPOJO" method="post">
		<br /> Username:<input type="text" name="username"><br />
		Password:<input type="password" name="password"><br /> Email:<input
			type="text" name="email"><br /> Age:<input type="text"
			name="age"><br /> City:<input type="text"
			name="address.city"><br /> Province:<input type="text"
			name="address.province"> <input type="submit" value="submit">
	</form>
	<a href="testREST/1">GET</a>
	<br />
	<form action="testREST" method="post">
		<input type="submit" value="POST">
	</form>
	<br />
	<form action="testREST/1" method="post">
		<input type="hidden" name="_method" value="PUT"> <input
			type="submit" value="PUT">
	</form>
	<br />
	<form action="testREST/1" method="post">
		<input type="hidden" name="_method" value="DELETE"> 
		<input type="submit" value="DELETE">
	</form>
	
	<hr><hr>
	<form action="testFileUpload" method="post" enctype="multipart/form-data">
		File:<input type="file" name="file"><br>
		Desc:<input type="text" name="desc"><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>
