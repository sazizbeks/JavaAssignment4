<%@include file="/jsp/index.components/header.jsp" %>
<%@include file="/js/bootstrap.js"%>
<script><%@include file="/js/searchBook.js"%></script>
<style>
    <%@include file="../css/index.css"%>
</style>
<main class="main">

    <div class="grid">

        <h1 class="text-center">Find book in library system</h1>
        <br>
        <input class="text" type="text" name="search" id="search" placeholder="Name of book" required><br>
        <span id="badResult" class="text-danger"></span>
        <span class="text-success" id="goodResult"></span>

        <div id="show" class="notshow">

            <div class="mb-4 card m-0 p-1 col-md-12">
                <div class="row container-fluid">

                    <div class="col-12 col-md-4 col-lg-5 imgMovieBlock">
                        <img src="" id="img" alt="" class="card-img imgMovie">
                    </div>

                    <div class="col-12 col-md-8 col-lg-7">

                        <div class="card-header"><b id="name"></b></div>

                        <div class="card-body py-2">

                            <ul class="list-group list-group-flush row">
                                <li class="list-group-item py-1">
                                    <dl class="row m-0">
                                        <dt class="text-dark mr-4">Author:</dt>
                                        <dd id="author"></dd>
                                    </dl>
                                </li>
                                <li class="list-group-item py-1">
                                    <dl class="row m-0">
                                        <dt class="text-dark mr-4">ISBN:</dt>
                                        <dd id="ISBN"></dd>
                                    </dl>
                                </li>
                                <li class="list-group-item py-1">
                                    <dl class="row m-0">
                                        <dt class="text-dark mr-4">Count of copies:</dt>
                                        <dd id="count_of_copy"></dd>
                                    </dl>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </div>

</main>


<%@include file="/jsp/index.components/footer.jsp" %>