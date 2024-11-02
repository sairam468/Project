<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Message</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="icon" href="images/logo.png" type="image/png">
</head>
<body>
  
        <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null) {
                out.println("<h3>" + msg + "</h3>");
            }
        %>
        <%@ include file="userLogin.html" %>
</body>
</html>
