package br.com.movie.model.bean;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "User")
@Table(name = "User")
public class UserBean {
	
	//Properties
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String name;
	private String password;
	@Transient
	private ArrayList<MovieBean> movies;
	
	//Constructor
	public UserBean(String username, String name, String password) {
		this.username = username;
		this.name = name;
		this.password = password;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
