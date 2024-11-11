<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Message - SAIBOOKS</title>
    <link rel="icon" href="images/logo.png" type="image/png">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="styles.css"> <!-- External CSS file -->
</head>
<body>
    <header>
        <img src="images/logo.png" alt="SAIBOOKS Logo" class="logo">
        <h1>SAIBOOKS</h1>
    </header>

    <div class="container">
        <div class="message">
            <%
                String msg = (String) request.getAttribute("msg");
                if (msg != null) {
                    out.println("<p>" + msg + "</p>");
                }
            %>
            <a href="UserLogin.jsp" class="btn">Back to Menu</a> <!-- Updated link to use the button style -->
        </div>
    </div>
</body>
</html>
