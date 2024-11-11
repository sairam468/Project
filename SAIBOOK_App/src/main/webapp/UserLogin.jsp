<%@ page language="java" contentType="text/html; charset=UTF-8" import="test.UserBean" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Login - SAIBOOKS</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
      <link rel="icon" href="images/logo.png" type="image/png">
</head>
<body>
    <header>
    <img src="images/logo.png" alt="SAIBOOKS Logo" class="logo">
        <h1>SAIBOOKS</h1>
           </header>
    <div class="container">
     <h2>User Login</h2>
        <h2>Welcome User</h2>
        <%
            UserBean ub = (UserBean) session.getAttribute("ubean");
            if (ub != null) {
                out.println("Hello, " + ub.getfName() + "<br>");
            } else {
                out.println("User not logged in...<br>");
            }
        %>
        <nav>
            <a href="viewBook">View Books</a>
            <a href="logout">Logout</a>
        </nav>
    </div>
    <script src="script.js"></script>
</body>
</html>
