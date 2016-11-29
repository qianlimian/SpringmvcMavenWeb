<html>
<body>
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
