<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma","no-cache");
		response.setHeader("Expires", "0");
		if(session.getAttribute("uname")==null){
			response.sendRedirect("index.jsp");
		}
	%>
	<h1>Logged In Successfully....</h1><br><br><br>
	<h3>Welcome ${uname}</h3>
	<form action="Logout"> 
    <input type="submit" value="Logout">
    </form>
</body>
</html>