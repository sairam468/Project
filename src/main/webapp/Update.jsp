
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book Details</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<header>
		<h1>SAIBOOKS - Update Book</h1>
	</header>
	<div class="container">
		<%
		AdminBean ab = (AdminBean) session.getAttribute("abean");
		BookBean bb = (BookBean) request.getAttribute("bbean");
		if (ab != null && bb != null) {
			out.println("Page Belongs to " + ab.getfName() + "<br>");
		} else {
			out.println("Session expired or book details are missing.<br>");
			return;
		}
		%>

		<form action="update" method="post">
			<h2>Update Book Details</h2>
			<input type="hidden" name="bcode" value="<%=bb.getCode()%>">
			<label for="bprice">Book Price:</label> <input type="text"
				name="bprice" value="<%=bb.getPrice()%>" required> <label
				for="bqty">Book Quantity:</label> <input type="text" name="bqty"
				value="<%=bb.getQty()%>" required> <input type="submit"
				value="Update Book">
		</form>
		<nav>
			<a href="book.html">Add Book</a> <a href="view">View Books</a> <a
				href="ViewBooks.jsp">Back</a> <a href="logout">Logout</a>
		</nav>
	</div>
</body>
</html>
