package br.com.movie.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.movie.model.bean.MovieBean;
import br.com.movie.model.bean.MovieList;
import br.com.movie.model.bo.MovieBO;
import br.com.movie.model.bo.UserBO;
import br.com.movie.model.dao.UserDAO;
import br.com.movie.model.network.MoviesAPI;

@WebServlet("/movie")
public class MovieController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MoviesAPI api;
	private List<MovieBean> movies;
	private int numberPages;
	private MovieBO movieBO;
	
	public MovieController() {
		this.api = new MoviesAPI();
		this.movies = new ArrayList<MovieBean>();
		this.numberPages = 8;
		this.movieBO = new MovieBO();
	}
	
	public List<MovieBean> loadMovies(int page, boolean favorites) {
		
		MovieList result;
		
		if (page == 0) {
			page = 1;
		}
		
		if (favorites) {
			movieBO.fetchMovies(UserBO.idUserLogged);
		} else {
			result = api.getMovies(page);
			this.movies = result.getResults();
		}
		
		return this.movies;
	}
	
	public MovieBean loadMovie(int id) {
		return api.getMovie(id);
	}
	
	public int getNumberPages() {
		return numberPages;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer page = Integer.parseInt(req.getParameter("actualPage"));
		
		if(page < 1) {
			req.setAttribute("actualPage", 1);
		} else if (page > numberPages) {
			req.setAttribute("actualPage", numberPages);
		} else {
			req.setAttribute("actualPage", page);
		}
		
		req.getRequestDispatcher("MovieListView.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 	
		int id = Integer.parseInt(req.getParameter("id"));
		boolean isFavorite = Boolean.parseBoolean(req.getParameter("isFavorite"));
		HttpSession session = req.getSession();
		
		if (session == null || session.getAttribute("username") == null) {
			req.getRequestDispatcher("Login.jsp").forward(req, resp);
		} else {
			if (isFavorite) {
				movieBO.addFavMovie(UserBO.idUserLogged, id);
			} else {
				movieBO.unlikeMovie(id);
			}
			req.getRequestDispatcher("MovieListView.jsp").forward(req, resp);
		}
	}
	
}


