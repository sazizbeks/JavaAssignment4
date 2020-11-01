<%@include file="index.components/header.jsp" %>
<%@include file="/js/bootstrap.js"%>
<script><%@include file="/js/readerDelete.js"%></script>
<script><%@include file="/js/readersBookDelete.js"%></script>

<s:query dataSource = "${snapshot}" var = "readers">
    SELECT * FROM READERS;
</s:query>

<s:query dataSource = "${snapshot}" var = "readersBooks">

    SELECT distinct fname, ISBN, NAME, AUTHOR
    FROM READERS R
    INNER JOIN readers_books RB ON RB.READER_IIN=R.IIN
    INNER JOIN BOOKS B ON RB.BOOK_ISBN=B.ISBN;

</s:query>

<main class="main">

    <div class="grid">

        <h1 class="text-center">Our Readers</h1>

        <c:forEach var="row" items="${readersBooks.rows}">
        <div class="text-center">
            <ul class="list-group">
                <li class="list-group-item">${row.iin}</li>
                <li class="list-group-item">${row.fname}</li>
                <li class="list-group-item">${row.ISBN}</li>
                <li class="list-group-item">${row.NAME}</li>
                <li class="list-group-item">${row.AUTHOR}</li>
            </ul>
        </div>
        </c:forEach>
    </div>



</main>
<%@include file="index.components/footer.jsp" %>