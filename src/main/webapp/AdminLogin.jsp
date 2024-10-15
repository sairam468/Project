<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="test.AdminBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Login - SAIBOOKS</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    
</head>
<body>
    <header>
        <h1>SAIBOOKS - Admin Login</h1>
    </header>
    <div class="container">
        <h2>Welcome Admin</h2>
        <%
            AdminBean ab = (AdminBean) session.getAttribute("abean");
            if (ab != null) {
                out.println("Hello, " + ab.getfName() + "<br>");
            } else {
                out.println("Admin not logged in.<br>");
            }
        %>
        <nav>
            <a href="book.html">Add Book</a>
            <a href="view">View Books</a>
            <a href="logout">Logout</a>
        </nav>
    </div>
    <script src="js/script.js"></script>
</body>
</html>
