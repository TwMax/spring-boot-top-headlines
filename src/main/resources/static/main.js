$(document).ready(function(){
    $('.eBtn').on('click',function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        var text=$(this).text();
            $.get(href, function(article){
                $('.myForm #author').val(article.author);
                $('.myForm #title').val(article.title);
                $('.myForm #description').val(article.description);
                $('.myForm #sourceName').val(article.sourceName);
                $('.myForm #date').val(article.date);
                $('.myForm #articleUrl').val(article.articleUrl);
                $('.myForm #imageUrl').val(article.imageUrl);
            })
            $('.myForm #exampleModal').modal();
    });

    $('.sBtn').on('click',function(event){
        var country = $("#country" ).val();
        var category = $("#category" ).val();
        $(this).attr('href', "http://localhost:8080/?country="+country+"&category="+category);
    })

 })