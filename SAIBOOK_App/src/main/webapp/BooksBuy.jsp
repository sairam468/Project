 <%@ page language="java" contentType="text/html; charset=UTF-8" import="test.*, java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add to Cart - SAIBOOKS</title>
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
          <h2>Add To Cart</h2>
            <a href="UserViewBooks.jsp">Back</a>
            <a href="logout">Logout</a>
        </nav>
        <h2>Book Details</h2>
        <table>
            <tr>
                <th>Book Code</th>
                <th>Book Name</th>
                <th>Author</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Enter Number of Books</th>
            </tr>
            <%
                String bCode = ((String) request.getParameter("bcode")).trim();
                ArrayList<BookBean> al = (ArrayList<BookBean>) session.getAttribute("al");
                if (al == null) {
                    out.println("<h3 style='color: red;'>No books found in the session...</h3><br>");
                } else {
                    Iterator<BookBean> i = al.iterator();
                    while (i.hasNext()) {
                        BookBean bb = (BookBean) i.next();
                        if (bCode.equals(bb.getCode().trim())) {
            %>
            <tr>
                <td><%= bb.getCode() %></td>
                <td><%= bb.getName() %></td>
                <td><%= bb.getAuthor() %></td>
                <td><%= bb.getPrice() %></td>
                <td><%= bb.getQty() %></td>
                <td>
                    <form action="addCart" method="post">
                        <label for="numOfbooks">Number of Books:</label> 
                        <input type="number" id="numOfbooks" name="numOfbooks" value="1" min="1" required> 
                        <input type="hidden" name="bcode" value="<%= bb.getCode() %>"> 
                        <input type="submit" value="Add to Cart">
                    </form>
                </td>
            </tr>
            <%
                        }
                    }
                }
            %>
        </table>
    </div>
</body>
</html>
