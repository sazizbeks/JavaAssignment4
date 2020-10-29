$(document).ready(function () {
    $('#IIN').keyup(function () {

        let xhttp = new XMLHttpRequest();
        let IIN = document.getElementById("IIN").value;

        if (IIN.length!=12 ) {
            document.getElementById("badResult").innerHTML = "Incorrect IIN! Write again!";
            document.getElementById("goodResult").innerHTML = "";
            document.getElementById("submit").disabled = true;
            return;
        }

        xhttp.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                let res = JSON.parse(this.responseText);
                if (res != "available") {
                    document.getElementById("badResult").innerHTML = "IIN is not available";
                    document.getElementById("goodResult").innerHTML = "";
                    document.getElementById("submit").disabled = true;
                } else {
                    document.getElementById("badResult").innerHTML = "";
                    document.getElementById("goodResult").innerHTML = "IIN is available";
                    document.getElementById("submit").disabled = false;
                }
            }
        };
        let toServ = IIN.toJSONString;
        xhttp.open("POST", "${pageContext.request.contextPath}/IIN?IIN=" + IIN, true);
        xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhttp.send(toServ);
    });
});
