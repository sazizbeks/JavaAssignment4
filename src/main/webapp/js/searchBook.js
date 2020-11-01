$(document).ready(function () {
    $('#search').keyup(function () {

        let xhttp = new XMLHttpRequest();
        let search = document.getElementById("search").value;

        if (search.length==0) {
            document.getElementById("badResult").innerHTML = "No such books in database";
            document.getElementById("goodResult").innerHTML = "";
            document.getElementById('show').className = "notshow";
            return;
        }

        xhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                let res = JSON.parse(this.responseText);
                if (res.length>0) {
                    document.getElementById('show').className = "show";
                    document.getElementById("img").src = res[0].url;
                    document.getElementById("name").innerHTML = res[0].name;
                    document.getElementById("author").innerHTML = res[0].author;
                    document.getElementById("ISBN").innerHTML = res[0].ISBN;
                    document.getElementById("count_of_copy").innerHTML = res[0].count_of_copy;
                    document.getElementById("badResult").innerHTML = "";
                } else {
                    document.getElementById("badResult").innerHTML = "No such books in database";
                    document.getElementById('show').className = "notshow";
                    document.getElementById("img").src = "";
                    document.getElementById("name").innerHTML = "";
                    document.getElementById("author").innerHTML = "";
                    document.getElementById("ISBN").innerHTML = "";
                    document.getElementById("count_of_copy").innerHTML = "";
                }
            }
        };
        let toServ = search.toJSONString;
        xhttp.open("GET", "${pageContext.request.contextPath}/search?search=" + search, true);
        xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhttp.send(toServ);
    });
});
