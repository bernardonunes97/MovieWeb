package br.com.movie.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.movie.model.bean.MovieBean;
import br.com.movie.model.bean.MovieList;
import br.com.movie.model.network.MoviesAPI;


public class MovieController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MoviesAPI api;
	private List<MovieBean> movies;
	
	public MovieController() {
		this.api = new MoviesAPI();
		this.movies = new ArrayList<MovieBean>();
	}
	
	public List<MovieBean> loadMovies(int page) {
		MovieList result = api.getMovies(page);
		this.movies.addAll(result.getResults());
		return this.movies;
	}
	
	public MovieBean loadMovie(int id) {
		return api.getMovie(id);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	}
	
}


