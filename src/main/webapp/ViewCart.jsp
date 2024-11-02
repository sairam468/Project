<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="test.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Books Cart</title>
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
        <h2>Book List</h2>
        <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null) {
                out.print(msg);
            }
            ArrayList<AddCartBean> acb = (ArrayList<AddCartBean>) session.getAttribute("acb");
            if (acb == null || acb.isEmpty()) {
                out.println("<p>No books available.</p>");
            } else {
                int totalBooks = 0;
                float totalPrice = 0.0f;
        %>
        <form action="buyAllBooks" method="post">
            <table>
                <tr>
                    <th>Serial No.</th>
                    <th>Book Image</th>
                    <th>Book Code</th>
                    <th>Book Name</th>
                    <th>Author</th>
                    <th>Price</th>
                    <th>Number of Books</th>
                    <th>Add one</th>
                    <th>Remove one</th>
                    <th>Remove From Cart</th>
                </tr>
                <%
                    int serialNo = 1; // Initialize serial number counter
                    // Iterate over the ArrayList, display book details, and calculate totals
                    for (AddCartBean acbean : acb) {
                        int bookQty = acbean.getNoOfBooks();
                        float bookPrice = acbean.getPrice() * bookQty;
                        totalBooks += bookQty;
                        totalPrice += bookPrice;

                        // Determine the book image based on the book code
                        String bookImage;
                        switch (acbean.getCode()) {
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
                            bookImage = "images/A115.png";
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
                    <td><img src="<%= bookImage %>" alt="<%= acbean.getName() %> Image" class="book-image" style="width: 50px; height: 75px;"></td>
                    <td><%= acbean.getCode() %></td>
                    <td><%= acbean.getName() %></td>
                    <td><%= acbean.getAuthor() %></td>
                    <td><%= acbean.getPrice() %></td>
                    <td><%= bookQty %></td>
                    <td><a href="updateBook?bcode=<%= acbean.getCode() %>&updation=<%=1%>">+1</a></td>
                    <td><a href="updateBook?bcode=<%= acbean.getCode() %>&updation=<%=-1%>">-1</a></td>
                    <td><a href="removeBook?bcode=<%= acbean.getCode() %>">Remove</a></td>
                </tr>
                <%
                    }
                %>
                <!-- Row showing total number of books and total price -->
                <tr>
                    <td colspan="5" style="text-align: right;"><strong>Total Number of Books:</strong></td>
                    <td><%= totalBooks %></td>
                    <td colspan="3" style="text-align: right;"><strong>Total Price:</strong></td>
                    <td><%= totalPrice %></td>
                </tr>
            </table>
            <input type="submit" value="Place Order" /> 
        </form>
        <%
            }
        %>
    </div>
</body>
</html>
