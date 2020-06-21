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
		changeStateLikeButton(isFavorite, button)
	});
}

function changeStateLikeButton(isFavorite) {
	
	if(!isFavorite) {
		button.classList.remove('btn-outline-primary');
		button.classList.add('btn-danger');
		likebtn.value = 'Unlike'
	} else {
		button.classList.remove('btn-danger');
		button.classList.add('btn-outline-primary');
		button.value = 'Like'
	}
}


//Busca de filmes
$(document).ready(function(){
	$("#txtSearch").on("keyup", function(){
		var value = $(this).val().toLowerCase();
		$(".card-container .card .card-body .card-text").filter(function(){
			$(this).parent().parent().parent().toggle($(this).text().toLowerCase().indexOf(value)>=0)
		});
	});
});