<%@ page language="java" contentType="text/html; charset=UTF-8" import="test.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Book</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
      <link rel="icon" href="images/logo.png" type="image/png">
</head>
<body>
    <header>
        <img src="images/logo.png" alt="SAIBOOKS Logo" class="logo">
        <h1>SAIBOOKS</h1>
           </header>
    <div class="container">
     <h2>Book Update</h2>
        <%
            AdminBean ab = (AdminBean) session.getAttribute("abean");
            String msg = (String) request.getAttribute("msg");
            out.println("Page Belongs to " + ab.getfName() + "<br>");
            out.println(msg);
        %>
        <nav>
            <a href="book.html">Add Book</a>
            <a href="view">View Books</a>
            <a href="logout">Logout</a>
        </nav>
    </div>
</body>
</html>
