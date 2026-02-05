<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<html>
<body>
	<h1 align="center">Book Selection Page</h1>
		<form action="SelectBook.do" method="post"> 
		Select book <p>
 
		Book: 
		<select name="topic" size="1"> 
		<option value="Java">Java</option> 
		<option value="Servlet">Servlet</option> 
		<option value="Struts">Struts</option> 

		</select> 
		<br><br> 
		
		<center> 
		<input type="submit"> 
		</center>
		</form>
		</body>
		</html></body>
</html>