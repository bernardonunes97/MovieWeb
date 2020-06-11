package br.com.movie.model.bean;

public class MovieBean {
	
	//Properties
	private int id;
	private String name;
	private float rating;
	private String genre;
	private int year;
	private int runtime;
	
	//Constructor
	public MovieBean(int id, String name, float rating, String genre, int year, int runtime) {
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.genre = genre;
		this.year = year;
		this.runtime = runtime;
	}

	//Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getRating() {
		return rating;
	}

	public String getGenre() {
		return genre;
	}

	public int getYear() {
		return year;
	}

	public int getRuntime() {
		return runtime;
	}	
}
