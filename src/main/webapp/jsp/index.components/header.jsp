<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<s:setDataSource var = "snapshot" driver = "com.mysql.cj.jdbc.Driver"
                 url = "jdbc:mysql://localhost:3306/assignment_week_8?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                 user = "root"  password = ""/>

<html>
<head>
    <title>Library</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<style>
    <%@include file="../../css/header.css"%>
    <%@include file="../../css/footer.css"%>
</style>


</head>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>

<body class="d-flex flex-column h-100">
<header class="header sticky sticky--top js-header">
    <div class="grid">
        <nav class="navigation">
            <ul class="navigation__list navigation__list--inline">
                <li class="navigation__item"><a href="<c:url value="/index.jsp"/>" class="is-active">Home</a></li>
                <li class="navigation__item"><a href="<c:url value="/jsp/register.jsp"/>" class="is-active">Register</a></li>
                <li class="navigation__item"><a href="<c:url value="/jsp/addBook.jsp"/>" class="is-active">Add book</a></li>
                <li class="navigation__item"><a href="<c:url value="/jsp/readerList.jsp"/>" class="is-active">Readers</a></li>
                <li class="navigation__item"><a href="<c:url value="/jsp/search.jsp"/>" class="is-active">Search Book</a></li>
                <li class="navigation__item"><a href="<c:url value="/logout"/>" class="is-active">LogOut</a></li>

            </ul>
        </nav>
    </div>
</header>
