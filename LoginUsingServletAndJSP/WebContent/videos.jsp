<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Videos Page</title>
</head>
<body>

	<%
		//This header is used for cache purpose 
		//for example if we go to videos page there u loggedout even though it logged out from the 
		//current user it is go back to the previous pages which should not be shown i.e secure pages.
		response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");//supports for HTTP 1.1 or higher
	
		response.setHeader("Pragma", "no-cache");// before http 1.1
	
		response.setHeader("Expires", "0");// if we use proxy servers

		if (session.getAttribute("userName") == null) {
			response.sendRedirect("login.jsp");
		}
	%>

	<h1>Welcome to Videos Page</h1>

	<a href="abc">Sample video</a>

	<a href="welcome.jsp"><b>Back to Home</b></a>
	<br>
	<br>

	<form action="LogoutServlet">
		<input type="submit" value="Logout" />
	</form>
</body>
</html>