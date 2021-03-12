<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1>WELCOME TO HCL TECHNOL0GIES</h1>

	<form action="Login" method = "post">
		Enter UserName: <input type="text" name="userName" /><br> <br>
		Enter Password: <input type="password" name="password" /><br> <br>
		
		<a href = "registration.jsp"><b>Sign up</b></a> &emsp; &emsp; &emsp;
		<input type="submit" value="login" /> 
		
	</form>
</body>
</html>