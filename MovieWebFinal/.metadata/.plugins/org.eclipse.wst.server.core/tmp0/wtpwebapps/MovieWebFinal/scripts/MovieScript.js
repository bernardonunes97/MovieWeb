function likeOrDislikeMovie(id, isFavorite) {
	
	$.ajax({
		url: `http://localhost:8080/ListMovies/movie?id=${id}&isFavorite=${!isFavorite}`,
		type: 'POST',
		sucess: function(message) {
			console.log(message);
		}, 
		error: function(message) {
			console.log(message);
		}
	}).done(function() {
		
	});
}

//Busca de filmes
$(document).ready(function(){
	$("#txtSearch").on("keyup", function(){
		var value = $(this).val().toLowerCase();
		$(".card .card-body .card-text").filter(function(){
			$(this).parent().parent().toggle($(this).text().toLowerCase().indexOf(value)>=0)
		});
	});
});