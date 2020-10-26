<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26.10.2020
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="addBook" method="post">
    <input type="text" name="ISBN" placeholder="ISBN" required>
    <br>
    <input type="text" name="name" placeholder="Name" required>
    <br>
    <input type="text" name="author" placeholder="Author" required>
    <br>
    <input type="number" name="count_of_copy" placeholder="Count of copy" required>
    <br>
    <input type="submit" value="submit">
</form>
</body>
</html>
