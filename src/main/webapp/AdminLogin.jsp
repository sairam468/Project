<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="test.AdminBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Login - SAIBOOKS</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
     <link rel="icon" href="images/logo.png" type="image/png">
</head>
<body>
    <header>
      <img src="images/logo.png" alt="SAIBOOKS Logo" class="logo">
        <h1>SAIBOOKS</h1>
         </header>
    <div class="container">
       <h2>Admin Login</h2>
        <h2>Welcome Admin</h2>
        <%
            AdminBean ab = (AdminBean) session.getAttribute("abean");
            if (ab != null) {
                out.print("<h3 style='color: green;'>Admin Login Successful...</h3><br>");
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
    <script src="script.js"></script>
</body>
</html>
