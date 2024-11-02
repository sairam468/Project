<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="test.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Book Details - SAIBOOKS</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="icon" href="images/logo.png" type="image/png">
</head>
<body>
    <header>
        <img src="images/logo.png" alt="SAIBOOKS Logo" class="logo">
        <h1>SAIBOOKS</h1>
  </header>
    <div class="container">
      <h2>Update Book</h2>
        <%
            AdminBean ab = (AdminBean) session.getAttribute("abean");
            BookBean bb = (BookBean) request.getAttribute("bbean");
            if (ab != null && bb != null) {
                out.println("Page Belongs to " + ab.getfName() + "<br>");
            } else {
                out.println("<h3 style='color: red;'>Session expired or book details are missing....</h3><br>");
                return; 
            }
        %>
        <form action="update" method="post">
            <h2>Update Book Details</h2>
            <input type="hidden" name="bcode" value="<%= bb.getCode() %>">
            <label for="bprice">Book Price:</label>
            <input type="text" name="bprice" value="<%= bb.getPrice() %>" required>
            <label for="bqty">Book Quantity:</label>
            <input type="text" name="bqty" value="<%= bb.getQty() %>" required>
            <input type="submit" value="update">
        </form>
        <nav>
            <a href="book.html">Add Book</a>
            <a href="view">View Books</a>
            <a href="ViewBooks.jsp">Back</a>
            <a href="logout">Logout</a>
        </nav>
    </div>
</body>
<script src="script.js"></script>
</html>
