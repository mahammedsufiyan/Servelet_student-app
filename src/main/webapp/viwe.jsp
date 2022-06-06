<%@page import="java.util.List"%>
<%@page import="com.ty.school.dto.Student"%>
<%@page import="com.mysql.cj.xdevapi.Table"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="viwe" method="get">
	<table border="3px solid black">
	<thead>
	<tr>
	<th>ID</th>
	<th>NAME</th>
	<th>EMAIL</th>
	<th>PHONE</th>
	<th>Edit</th>
	<th>Delete</th>
	</tr>
	
	<tr>
	<%    List<Student> stud =(List<Student>)request.getAttribute("list"); %>
	<% for(Student student:stud) 
	{
	%>
	<tr>
	
	<td><%= student.getId() %></td>
	<td><%=student.getName() %></td>
	<td><%=student.getEmail() %></td>
	<td><%=student.getPhone() %></td>
	
	<td><a href="update?id=<%=student.getId()%>">Edit</a>
	<td><a href="delete?id=<%=student.getId()%>">Delete</a>
	<td></td>
	
	
	
	
	</tr>
	
	
	
	<%} %>
	
	</tr>
	
	
	
	
	
	</thead>
	</table>
	
	</form>
	
	
	
	
	
</body>
</html>