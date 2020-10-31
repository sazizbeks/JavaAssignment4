<%@include file="index.components/header.jsp" %>
<%@include file="/js/bootstrap.js"%>

<s:query dataSource = "${snapshot}" var = "result">
    SELECT * from readers;
</s:query>

<main class="main">

    <div class="grid">

        <h1 class="text-center">Our Readers</h1>

        <c:forEach var="row" items="${result.rows}">
            <div style="border-right: black 2px solid; border-left: black 2px solid;">
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">${row.iin}</li>
                    <li class="list-group-item">${row.fname}</li>
                    <li class="list-group-item">${row.lname}</li>
                </ul>
                <br>
                <div class="text-center">
                    <button class="edit btn btn-outline-info" value="edit">Edit</button>
                    <button class="delete btn btn-outline-info" value="delete">Delete</button>
                </div>
            </div>
            <hr>
        </c:forEach>

    </div>



</main>
<%@include file="index.components/footer.jsp" %>