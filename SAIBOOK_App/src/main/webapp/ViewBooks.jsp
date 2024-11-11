<%@ page language="java" contentType="text/html; charset=UTF-8" import="test.*, java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Books</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="icon" href="images/logo.png" type="image/png">
</head>
<body>
    <header>
    <img src="images/logo.png" alt="SAIBOOKS Logo" class="logo">
        <h1>SAIBOOKS</h1>
    </header>
    <div class="container">
            <h2>View Books</h2>
        <nav>
            <a href="AdminLogin.jsp">Back</a>
            <a href="logout">Logout</a>
        </nav>
        <h2>Available Books</h2>
        <table>
            <tr>
                <th>Book Code</th>
                <th>Book Name</th>
                <th>Author</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Action</th>
            </tr>
            <%
            String msg = (String) request.getAttribute("msg");
            if (msg != null) {
                out.print(msg);
            }
                ArrayList<BookBean> al = (ArrayList<BookBean>) session.getAttribute("al");
                if (al != null && !al.isEmpty()) {
                    for (BookBean bb : al) {
            %>
            <tr>
                <td><%= bb.getCode() %></td>
                <td><%= bb.getName() %></td>
                <td><%= bb.getAuthor() %></td>
                <td><%= bb.getPrice() %></td>
                <td><%= bb.getQty() %></td>
                <td>
                    <a href="edit?bcode=<%= bb.getCode() %>">Update</a><br>
                                          (or)<br>
                    <a href="delete?bcode=<%= bb.getCode() %>">Delete</a>
                </td>
            </tr>
            <%
                    }
                } else {
                    out.println("<tr><td colspan='6'>No books available.</td></tr>");
                }
            %>
        </table>
    </div>
</body>
</html>
