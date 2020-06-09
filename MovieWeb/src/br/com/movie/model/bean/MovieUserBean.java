package br.com.movie.model.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MovieUser")
public class MovieUserBean {
	
	//Properties
	@Id
	private int id;
	private int userId;
	private int movieId;
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
}
