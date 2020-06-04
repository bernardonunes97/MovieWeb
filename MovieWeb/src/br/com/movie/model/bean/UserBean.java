package br.com.movie.model.bean;

public class UserBean {
	
	//properties
	private int id;
	private String username;
	private String name;
	private String password;
	
	//Constructor
	public UserBean(int id, String username, String name, String password){
		this.id = id;
		this.username = username;
		this.name = name;
		this.password = password;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
