package br.com.movie.model.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieBean {
	
	private int id;
	
	private String title;
	
	@JsonProperty("vote_average")
	private float vote;
	
	@JsonProperty("poster_path")
	private String poster;
	
	@JsonIgnore
	private boolean isFavorite = false;
	
	//MARK:- Getters
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public float getVote() {
		return vote;
	}

	public String getPoster() {
		return poster;
	}

	public boolean getIsFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
}
