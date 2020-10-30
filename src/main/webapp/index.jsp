<%@include file="jsp/index.components/header.jsp" %>
<script><%@include file="js/bookDelete.js"%></script>
<main class="main">

    <div class="grid">

        <h1 class="text-center">Astana IT University Library</h1>

        <p>Astana IT University Library is the first University Library in Kazakhstan, headquartered in Astana,
            It was founded in 2020 as an University Shop,
            and will be re-registered in 2021 as a joint stock company due to joint stock company law changes.
            The Shop is owned 100% by Astana IT University Library.</p>
        <p>Astana IT University is a leading competence center for digital transformation in Central Asia. Training of
            highly qualified specialists in the field of digital economy is taking place on the basis of
            interdisciplinary technologies.</p>
        <p>Astana IT University got access to the EBSCO electronic resource databases! <br> EBSCO in Astana IT
            University
            EBSCO is the largest aggregator of scientific resources from the world's leading publishing houses.
            EBSCO provides a wide variety of licensed full-text databases from leading information providers, including
            Scopus and Web of Science.
            Now students and teachers of the university have access to the following resources of the EBSCO host
            information system</p>
        <br>

        <div class="container">
            <h1 class="text-center">Our books</h1>
            <c:forEach var="row" items="${result.rows}">
                <div class="mb-4 card m-0 p-1 col-md-12">
                    <div class="row container-fluid">

                        <div class="col-12 col-md-4 col-lg-5 imgMovieBlock">
                            <img src="${row.img_url}" alt="" class="card-img imgMovie">
                        </div>

                        <div class="col-12 col-md-8 col-lg-7">

                            <div class="card-header"><b>${row.name}</b></div>

                            <div class="card-body py-2">

                                <ul class="list-group list-group-flush row">
                                    <li class="list-group-item py-1">
                                        <dl class="row m-0">
                                            <dt class="text-dark mr-4">Author:</dt>
                                            <dd>${row.author}</dd>
                                        </dl>
                                    </li>
                                    <li class="list-group-item py-1">
                                        <dl class="row m-0">
                                            <dt class="text-dark mr-4">ISBN:</dt>
                                            <dd>${row.isbn}</dd>
                                        </dl>
                                    </li>
                                    <li class="list-group-item py-1">
                                        <dl class="row m-0">
                                            <dt class="text-dark mr-4">Count of copies:</dt>
                                            <dd>${row.count_of_copy}</dd>
                                        </dl>
                                    </li>
                                </ul>
                                <div class="row text-center">
                                    <a class="col-md-6" style="text-decoration: none" href="<c:url value=""/>">
                                        <button type="button" class="btn btn-lg btn-block btn-outline-primary">Update</button>
                                    </a>
                                    <a class="col-md-6" style="text-decoration: none">
                                        <button id="${row.isbn}" type="button" class="delete btn btn-lg btn-block btn-outline-primary">Delete</button>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

    </div>



</main>
<%@include file="jsp/index.components/footer.jsp" %>