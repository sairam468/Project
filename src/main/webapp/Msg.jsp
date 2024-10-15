<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Message</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <header>
        <h1>SAIBOOKS - Message</h1>
    </header>
    <div class="container">
        <%
            String msg = (String) request.getAttribute("msg");
            out.println("<div>" + msg + "</div>");
        %>
        <%@ include file="home.html" %>
    </div>
</body>
</html>
