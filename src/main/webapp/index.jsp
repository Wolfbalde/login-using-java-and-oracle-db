<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="Welcome.css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<form action="Login" method="post">
	<body>

		Enter your Email-id:
		<input type="email" name="login" required="required">
		<br>
		<br> Enter your Password:
		<input type="password" name="pas" required="required">
		<br>
		<br>
		<input type="submit" value="Login" name="L"><br><br>
	

		<h3>Don't have an account? Sign up now</h3>
		<input type="submit" value="Register" name="R">
	</body>
</form>
</html>