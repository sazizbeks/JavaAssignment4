$(document).ready(function (){
    $('.delete').click(function (){
        let xhttp = new XMLHttpRequest();
        var iin = $(this).attr('id');
        var btnValue = $(this).val();
        var isbn = $('#isbn').val()
        alert(isbn);


        xhttp.onreadystatechange = function (){
            if(this.readyState === 4 && this.status === 200){
                location.reload();
            }
        };
        xhttp.open("POST", "${pageContext.request.contextPath}/readerServ?iin=" + iin + "&btn=" + btnValue , true);
        xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhttp.send();
    });
});
