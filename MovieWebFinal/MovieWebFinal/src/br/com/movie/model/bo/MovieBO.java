package br.com.movie.model.bo;

import java.util.List;

import br.com.movie.model.bean.MovieUserBean;
import br.com.movie.model.dao.MovieDAO;

public class MovieBO {
	
	// Properties
	private MovieDAO movieDAO;

	// Constructor
	public MovieBO() {
		this.movieDAO = new MovieDAO();
	}
	
	// Methods
	
	/**
	 * Método que adiciona filme aos favoritos.
	 * @param userID id do usuario no banco.
	 * @param movieID id do filme.
	 * @return Boolean se a operacao foi concluida.
	*/
	public boolean addFavMovie(int userID, int movieID) {
		MovieUserBean favMovie = new MovieUserBean();
		favMovie.setMovieId(movieID);
		favMovie.setUserId(userID);
		favMovie.setActive(true);
		
		return movieDAO.create(favMovie);
	}
	
	/**
	 * Desfavorita filme logicamente
	 * @param movieID id do filme
	 * @return Boolean se a operacao foi concluida.
	*/
	public boolean unlikeMovie(int movieId) {
		return movieDAO.delete(movieId);
	}
	
	/**
	 * Retorna lista de filmes favoritos
	 * @param userID id do usuário
	 * @return  List<MovieUserBean> lista com os filmesÍ
	*/
	public List<MovieUserBean> fetchMovies(int userId) {
		return movieDAO.fetchUserId(userId);
	}
}
