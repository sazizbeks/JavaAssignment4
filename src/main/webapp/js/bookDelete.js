$(document).ready(function (){
    $('.delete').click(function (){

        let xhttp = new XMLHttpRequest();
        var isbn = $(this).attr('id');


        xhttp.onreadystatechange = function (){
            if(this.readyState === 4 && this.status === 200){
                let res = JSON.parse(this.responseText);

                if(res !== "deleted"){
                    document.getElementById("result1").innerHTML = "system out error 404";
                }else{
                    document.getElementById("result1").innerHTML = "Deleted successfully";
                }
            }
        };

        let toServlet = isbn.toJSONString;
        xhttp.open("POST", "${pageContext.request.contextPath}/bookServlet?isbn=" + isbn, true);
        xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhttp.send(toServlet);


        // $.ajax('bookServlet',{
        //     type: 'POST',
        //     data: {isbn:isbn},
        //     success: function (result){
        //         alert(result);
        //         $('#result1').html(result);
        //     }
        // });
    });
});
