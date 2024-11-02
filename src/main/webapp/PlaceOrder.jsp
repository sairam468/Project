<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Place Order - SAIBOOKS</title>
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
        <h2>Review Your Order</h2>
        
        <!-- Shipping Address -->
        <div class="details">
            <h3>Shipping Address:</h3>
            <label>Name:</label>
            <p><%= request.getParameter("name") %></p>
            <label>Address:</label>
            <p><%= request.getParameter("address") %></p>
            <label>City:</label>
            <p><%= request.getParameter("city") %></p>
            <label>State:</label>
            <p><%= request.getParameter("state") %></p>
            <label>Zip Code:</label>
            <p><%= request.getParameter("zipcode") %></p>
            <label>Country:</label>
            <p><%= request.getParameter("country") %></p>
        </div>

        <!-- Payment Information -->
        <div class="details">
            <h3>Payment Information:</h3>
            <label>Payment Type:</label>
            <p><%= request.getParameter("paymentType") %></p>
            <label>Card Number (if applicable):</label>
            <p><%= request.getParameter("cardNumber") != null ? request.getParameter("cardNumber") : "N/A" %></p>
        </div>

        <!-- Place Order Form -->
        <form action="buyAllBooks" method="post">
            <!-- Hidden inputs to pass data to the servlet -->
            <input type="hidden" name="name" value="<%= request.getParameter("name") %>">
            <input type="hidden" name="address" value="<%= request.getParameter("address") %>">
            <input type="hidden" name="city" value="<%= request.getParameter("city") %>">
            <input type="hidden" name="state" value="<%= request.getParameter("state") %>">
            <input type="hidden" name="zipcode" value="<%= request.getParameter("zipcode") %>">
            <input type="hidden" name="country" value="<%= request.getParameter("country") %>">
            <input type="hidden" name="paymentType" value="<%= request.getParameter("paymentType") %>">
            <input type="hidden" name="cardNumber" value="<%= request.getParameter("cardNumber") != null ? request.getParameter("cardNumber") : "" %>">
            <input type="submit" value="Place Order" class="btn"> <!-- Updated to use the same button style -->
        </form>
    </div>
</body>
</html>
