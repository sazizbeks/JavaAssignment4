$(document).ready(function (){
    $('.delete').click(function (){

        event.preventDefault();

        var isbn = $(this).attr('id');

        $.ajax('bookServlet',{
            type: 'POST',
            data: {isbn:isbn},
            success: function (result){
                alert(result);
                $('#result1').html(result);
            }
        });
    });
});
