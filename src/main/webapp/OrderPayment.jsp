<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Payment - SAIBOOKS</title>
    <link rel="icon" href="images/logo.png" type="image/png">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="styles.css"> <!-- External CSS file -->
    <script src="OrderPaymentValidation.js"></script> <!-- External JavaScript for validation -->
</head>
<body>
    <header>
        <img src="images/logo.png" alt="SAIBOOKS Logo" class="logo">
        <h1>SAIBOOKS</h1>
    </header>
    <div class="container">
        <h2>Payment Details</h2>
        <form action="PlaceOrder.jsp" method="post">
            <%-- Hidden inputs to pass data from the previous page --%>
            <input type="hidden" name="name" value="<%= request.getParameter("name") %>">
            <input type="hidden" name="address" value="<%= request.getParameter("address") %>">
            <input type="hidden" name="city" value="<%= request.getParameter("city") %>">
            <input type="hidden" name="state" value="<%= request.getParameter("state") %>">
            <input type="hidden" name="zipcode" value="<%= request.getParameter("zipcode") %>">
            <input type="hidden" name="country" value="<%= request.getParameter("country") %>">

            <div class="form-group">
                <label for="paymentType">Payment Type:</label>
                <select id="paymentType" name="paymentType" required onchange="updateInputField()">
                    <option value="" disabled selected>Select payment method</option>
                    <option value="Credit Card">Credit Card</option>
                    <option value="Debit Card">Debit Card</option>
                    <option value="Net Banking">Net Banking</option>
                    <option value="UPI">UPI</option>
                    <option value="Cash on Delivery">Cash on Delivery</option>
                </select>
            </div>
            <div class="form-group">
                <label id="dynamicFieldLabel" for="dynamicField">Card Number:</label>
                <input type="text" id="dynamicField" name="dynamicField" placeholder="Enter card number" required>
            </div>
            <input type="submit" class="btn" value="Place Order" class="btn"> <!-- Updated submit button -->
        </form>
    </div>
</body>
</html>
