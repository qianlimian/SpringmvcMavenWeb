<html>
<body>
<a href="testMap">textMap</a>
<br />
<a href="testModelAndView">testModelAndView</a>
<form action="testPOJO" method="post"><br />
Username:<input type="text" name="username"><br />
Password:<input type="password" name="password"><br />
Email:<input type="text" name="email"><br />
Age:<input type="text" name="age"><br />
City:<input type="text" name="address.city"><br />
Province:<input type="text" name="address.province">
<input type="submit" value="submit">
</form>
<a href="testREST/1">GET</a>
<br />
<form action="testREST" method="post">
	<input type="submit" value="POST">
</form>
<br />
<form action="testREST/1">
	<input type="hidden" name="_method" value="PUT">
	<input type="submit" value="PUT">
</form>
<br />
<form action="testREST/1">
	<input type="hidden" name="_method" value="DELETE">
	<input type="submit" value="DELETE">
</form>
</body>
</html>
