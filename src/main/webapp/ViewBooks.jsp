
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import ="test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Books</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <header>
        <h1>SAIBOOKS - View Books</h1>
    </header>
    <div class="container">
        <nav>
            <a href="book.html">Add Book</a>
            <a href="AdminLogin.jsp">Back</a>
            <a href="logout">Logout</a>
        </nav>
        <h2>Book List</h2>
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
            ArrayList al=(ArrayList)session.getAttribute("al");
            Iterator<BookBean> i=al.iterator();
        	while(i.hasNext()){
        		BookBean bb=(BookBean)i.next();
            %>
            <tr>
                <td><%= bb.getCode() %></td>
                <td><%= bb.getName() %></td>
                <td><%= bb.getAuthor() %></td>
                <td><%= bb.getPrice() %></td>
                <td><%= bb.getQty() %></td>
                <td><a href="edit?bcode=<%= bb.getCode() %>">Edit</a></td>
                <td><a href="delete?bcode=<%= bb.getCode() %>">Delete</a></td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
</body>
</html>

