$(document).ready(function () {
    $('#ISBN').keyup(function () {

        let xhttp = new XMLHttpRequest();
        let ISBN = document.getElementById("ISBN").value;

        if (ISBN == "") {
            document.getElementById("badResult").innerHTML = "Please, enter ISBN number";
            document.getElementById("goodResult").innerHTML = "";
            document.getElementById("submit").disabled = true;
            return;
        }

        xhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                let res = JSON.parse(this.responseText);
                if (res != "available") {
                    document.getElementById("badResult").innerHTML = "ISBN is not available";
                    document.getElementById("goodResult").innerHTML = "";
                    document.getElementById("submit").disabled = true;
                } else {
                    document.getElementById("badResult").innerHTML = "";
                    document.getElementById("goodResult").innerHTML = "ISBN is available";
                    document.getElementById("submit").disabled = false;
                }
            }
        };
        let toServ = ISBN.toJSONString;
        xhttp.open("POST", "${pageContext.request.contextPath}/ISBN?ISBN=" + ISBN, true);
        xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhttp.send(toServ);
    });
});
