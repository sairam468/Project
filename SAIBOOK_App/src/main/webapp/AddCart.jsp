<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Books Car</title>
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
           <h2>Books Cart</h2>
            <a href="UserViewBooks.jsp">Back</a>
            <a href="logout">Logout</a>
        </nav>
        
        <%
        String msg = (String) request.getAttribute("msg");
        if (msg != null) {
            out.println("<p class='message'>" + msg + "</p>");
        } else {
            out.println("<p class='message'>No message available.</p>");
        }
        %>
    </div>
</body>
</html>
