<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Message</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="icon" href="images/logo.png" type="image/png">
</head>
<body>

    <!-- Display the logout message here -->
    <div class="message">
        <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null) {
                out.println("<p>" + msg + "</p>");
            }
        %>
    </div>

    <%@ include file="home.html"%>

</body>
</html>
