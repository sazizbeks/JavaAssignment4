<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book update</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <style>
        <%@include file="../css/index.css"%>
    </style>
</head>
<%@include file="../js/bootstrap.js"%>
<body>
<!-- main -->
<div class="main-w3layouts wrapper">
    <h1>Astana IT University Library</h1>
    <div class="main-agileinfo">
        <div class="agileits-top">
            <form action="<c:url value='/updateBook'/>" method="post">
                <label for="name" style="color: white">Name</label>
                <input id="name" class="text" type="text" name="Name" placeholder="Name"><br>

                <label for="author" style="color: white">Author</label>
                <input id="author" class="text" type="text" name="Author" placeholder="Author"><br>

                <label for="countOfCopy" style="color: white">Count of copy</label>
                <input id="countOfCopy" class="text" type="text" name="CountOfCopy" placeholder="Count of copy"><br>

                <label for="imageURL" style="color: white">Image URL</label>
                <input id="imageURL" class="text" type="text" name="image" placeholder="Image"><br>

                <input type="hidden" name="ISBN" id="ISBN" value="<%=request.getParameter("isbn")%>">
                <input  name="btn" type="submit" value="Edit" id="submit">
            </form>
        </div>
    </div>
</div>
</body>
</html>