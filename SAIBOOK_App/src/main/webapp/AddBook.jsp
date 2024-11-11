<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="test.AdminBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book - SAIBOOKS</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="icon" href="images/logo.png" type="image/png">
</head>
<body>
    <header>
        <img src="images/logo.png" alt="SAIBOOKS Logo" class="logo">
        <h1>SAIBOOKS</h1>
    </header>
    <div class="container">
        <nav>
            <a href="book.html">Add Book</a>
            <a href="view">View Books</a>
            <a href="logout">Logout</a>
        </nav>
        <h2>Add New Book</h2>
        <%
            AdminBean ab = (AdminBean) session.getAttribute("abean");
            String msg = (String) request.getAttribute("msg");
            if (msg != null) {
                out.println("<div>" + msg + "</div>");
            }
        %>
        <form action="add" method="post">
            <label for="bcode">Book Code:</label>
            <input type="text" name="bcode" required>
            <label for="bname">Book Name:</label>
            <input type="text" name="bname" required>
            <label for="bauthor">Book Author:</label>
            <input type="text" name="bauthor" required>
            <label for="bprice">Book Price:</label>
            <input type="text" name="bprice" required>
            <label for="bqty">Book Quantity:</label>
            <input type="text" name="bqty" required>
            <input type="submit" value="Add Book">
        </form>
    </div>
</body>
<script src="script.js"></script>
</html>
