function likeOrDislikeMovie(isFavorite) {

}

$(document).ready(function(){
	$("#txtSearch").on("keyup", function(){
		var value = $(this).val().toLowerCase();
		$(".card-container .card .card-body .card-text").filter(function(){
			$(this).parent().parent().parent().toggle($(this).text().toLowerCase().indexOf(value)>=0)
		});
	});
});