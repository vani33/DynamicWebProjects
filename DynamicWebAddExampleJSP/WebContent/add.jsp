<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add.jsp page</title>
</head>
<body bgcolor = "red">

	<%-- If we want to import any packages into the jsp then those can be written in directive tag(<%@ %>) 
		 
		<%@page attribute="value" attribute="value" ....%>
		
		Attributes are :
		language = "scripting language"
		extends="classname"
		import="importList"
		session="true|false"
		autoFlush="true|false"
		contentType="ctinfo"
		errorPage="error_url"
		isErrorPage="true|false"
		info="information"
		isELIgnored="true|false"
		isThreadSafe="true|false"
		 
		 <%@page import="java.util.*" %>
	
	In directive tag they are two more tags @include and @taglib
	
	@Include tag can be used if we want to use another jsp in this jsp examples are headers and footers.
	<%@ include file="header.jsp" %>
	
	@taglib tag can be used if we want to use any external tags.
	<%@taglib uri="uri" prefix="fx"%>
	
	uri is the uri belongs to specific libraries if we want to use any tags within that library we will use it 
	with the prefix mentioned--%>
	
	
	
	<!-- If u want to declare any varibales or methods outside the service method of servlet then those 
	should be written in declarative tag(<%! %>) -->
		<%-- <%!int i = 1; %> --%>
		
		

	<%-- All the logic which is written in service method of servlet can be written in Scriplet tag (<% %>)  --%>
	<%
		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2")); 
		int k = i + j;

		out.println("Result is " + k);
	%>
	
	<%-- If u want to print any values for example out.println statements can be written in expression tag(<%= %>) --%>
	<%-- <%=out.println("Result is " + k); %> --%>
	
	
	<!-- Implicit objects in are: (can be used in Scriplet and Expression)
	
	request (HttpServletRequest)
	response(HtppServletResponse)
	pageContext(PageContext) Ex:pageContext.setAttribute("name", "vani", PageContext.SESSION_SCOPE);
	out ~PrintWriter
	session (HttpSession)
	application(SetveltContext)
	config(ServletConfig) 
	exception (only works if we mention isErrorPage= true in page attribute)
	-->
	
	
	<!-- Exception Handling in jsp 
	
	We can use try and catch as we use in java classes but itsnot the best practise in web world
	so we will use another separate jsp page(error.jsp) to display the error message. for that we need
	to use errorPage="error.jsp" in page attribute and in error.jsp we can exception implicit object
	to display the error message for that we need to use isErrorPage = "true" in error.jsp page.
	
	
	-->
	
</body>
</html>