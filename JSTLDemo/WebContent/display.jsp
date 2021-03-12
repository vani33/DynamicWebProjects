<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String label = request.getAttribute("name").toString();
		out.println("Welcome " + label);
	%>

	<!-- With jsp we can use java code inside html, it dont look good to have all the code in jsp so we go 
	JSTL(Jsp standard tag library). with jstl we can use EL and also some tags.
	
	To use JSTL we need to add jstl 1.2 jar inside lib folder.Also, need to add taglib directive with
	specified uri. -->


	${name}
	<!-- Expression language -->

	<c:out value="${name}"></c:out>
	<br>
	<!-- JSTL Tags -->

	<c:out value="${StudentName}"></c:out>
	<br>
	<!-- to print entire object we need to add tostring method in student class -->

	<c:forEach items="${Students}" var="s">
		${s} <br>
	</c:forEach>

	<!-- To use sql related tags we need to add taglib with sql related uri. 
	To use database connections we need to add mysql connector java jar in the buildpath and lib folder
	-->

	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/hcl" user="root" password="root" />

	<sql:query var="rs" dataSource="${db}">select * from jstldemo</sql:query>
	
	<c:forEach items="${rs.rows}" var="jstl">
			<c:out value="${jstl.rollno}"></c:out> : <c:out value="${jstl.name}"></c:out>
			<br>
	</c:forEach> 
	
	
	<%-- <form method="post">
	<table>
		<tr>
			<td>Enter Roll no</td>
			<td><input type="text" name="rollno"></td>
		</tr>
		<tr>
			<td>Enter Name</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
		<td></td>
		<td><input type="submit" value="submit"></td>
		</tr>
	</table>
	</form>
		<sql:update dataSource="${db}" var="updatedTable">insert into table jstldemo(rollno, name) values(?,?)
			<sql:param value="${param.rollno}"></sql:param>
			<sql:param value="${param.name}"></sql:param>
		</sql:update>
 --%>
		


		<!-- To use function related tags we need to add taglib with function related uri. -->

		<c:set var="str" value="Vani is a Software Engineer"></c:set>

		Length of the string: ${fn:length(str)}
		<br> Splitted words of the string are:
		<c:forEach items="${fn:split(str,' ')}" var="s">
	${s} <br>
		</c:forEach>

		index: ${fn:indexOf(str,"is")}
		<br> is there: ${fn:contains(str,"Vani")}
		<br>

		<c:if test="${fn:contains(str,'Vani')}">
			<c:out value="Vani is there"></c:out>
			<br>
		</c:if>

		<c:if test="${fn:endsWith(str,'Engineer')}">
			<c:out value="You are right"></c:out>
			<br>
		</c:if>
</body>
</html>