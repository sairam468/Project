<%@ page language="java" contentType="text/html; charset=UTF-8" import="test.*,java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Books - SAIBOOKS</title>
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
            <a href="viewCart">View Cart</a>
            <a href="UserLogin.jsp">Back</a>
            <a href="logout">Logout</a>
        </nav>
        <h2>Book List</h2>
        <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null) {
                out.print("<p style='color: red;'>" + msg + "</p>");
            }
            ArrayList<BookBean> al = (ArrayList<BookBean>) session.getAttribute("al");
            if (al == null || al.isEmpty()) {
                out.println("<p>No books available.</p>");
            } else {
        %>
        <table>
            <tr>
                <th>Serial No.</th>
                <th>Book Image</th>
                <th>Book Code</th>
                <th>Book Name</th>
                <th>Author</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Action</th>
            </tr>
            <%
            int serialNo = 1; // Initialize the serial number counter
            for (BookBean bb : al) {
                String bookImage; // Declare variable for book image
                switch (bb.getCode()) {
                    case "A100":
                        bookImage = "images/A100.png";
                        break;
                    case "A101":
                        bookImage = "images/A101.png";
                        break;
                    case "A102":
                        bookImage = "images/A102.png";
                        break;
                    case "A103":
                        bookImage = "images/A103.png";
                        break;
                    case "A104":
                        bookImage = "images/A104.png";
                        break;
                    case "A105":
                        bookImage = "images/A105.png";
                        break;
                    case "A106":
                        bookImage = "images/A106.png";
                        break;
                    case "A107":
                        bookImage = "images/A107.png";
                        break;
                    case "A108":
                        bookImage = "images/A108.png";
                        break;
                    case "A109":
                        bookImage = "images/A109.png";
                        break;
                    case "A110":
                        bookImage = "images/A110.png";
                        break;
                    case "A111":
                        bookImage = "images/A111.png";
                        break;
                    case "A112":
                        bookImage = "images/A112.png";
                        break;
                    case "A113":
                        bookImage = "images/A113.png";
                        break;
                    case "A114":
                        bookImage = "images/A114.png";
                        break;
                    case "A115":
                        bookImage = "images/A115.jpg";
                        break;
                    case "A116":
                        bookImage = "images/A116.png";
                        break;
                    case "A117":
                        bookImage = "images/A117.png";
                        break;
                    case "A118":
                        bookImage = "images/A118.png";
                        break;
                    case "A119":
                        bookImage = "images/A119.png";
                        break;
                    case "A120":
                        bookImage = "images/A120.png";
                        break;
                    default:
                        bookImage = "images/logo.png"; // Fallback image
                        break;
                }
            %>
            <tr>
                <td><%= serialNo++ %></td>
                <td><img src="<%= bookImage %>" alt="<%= bb.getName() %> Image" class="book-image"></td>
                <td><%= bb.getCode() %></td>
                <td><%= bb.getName() %></td>
                <td><%= bb.getAuthor() %></td>
                <td><%= bb.getPrice() %></td>
                <td><%= bb.getQty() %></td>
                <td><a href="buy?bcode=<%= bb.getCode() %>">Add to Cart</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <%
            }
        %>
    </div>
</body>
</html>
