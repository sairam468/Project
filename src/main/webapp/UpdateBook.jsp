<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<header>
		<h1>SAIBOOKS - Update Book</h1>
	</header>
	<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
String msg=(String)request.getAttribute("msg");
out.println("Page Belongs to "+ab.getfName()+"<br>");
out.println(msg);
%>
	<a href="book.html">AddBook</a>
	<a href="view">ViewBooks</a>
	<a href="logout">Logout</a>
</body>
</html>
