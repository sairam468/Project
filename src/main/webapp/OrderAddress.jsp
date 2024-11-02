<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order Address - SAIBOOKS</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="icon" href="images/logo.png" type="image/png">
</head>
<body>
    <header>
        <img src="images/logo.png" alt="SAIBOOKS Logo" class="logo">
        <h1>SAIBOOKS</h1>
    </header>
    <div class="container">
        <h2>Shipping Address</h2>
        <form action="OrderPayment.jsp" method="post">
            <label for="name">Full Name:</label>
            <input type="text" id="name" name="name" required>
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>
            <label for="city">City:</label>
            <input type="text" id="city" name="city" required>
            <label for="state">State:</label>
            <input type="text" id="state" name="state" required>
            <label for="zipcode">Zip Code:</label>
            <input type="text" id="zipcode" name="zipcode" required>
            <label for="country">Country:</label>
            <input type="text" id="country" name="country" required>
            <input type="submit" class="btn" value="Proceed">
        </form>
    </div>
    <script src="OrderAddressValidation.js"></script>
</body>
</html>
