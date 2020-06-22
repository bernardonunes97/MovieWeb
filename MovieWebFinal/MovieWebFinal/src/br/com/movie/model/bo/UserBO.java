package br.com.movie.model.bo;


import br.com.movie.model.bean.UserBean;
import br.com.movie.model.dao.UserDAO;

public class UserBO {
	
	//Properties
	private UserDAO userDAO;
	// Temp
	public static int idUserLogged;
	
	//Constructor
	public UserBO() {
		this.userDAO = new UserDAO();
	}
	
	//Methods
	public boolean createNewUser(String username, String name, String password){
		if (!validateUsername(username)) {
			return false;
		}
		
		UserBean user = new UserBean(username, name, password);
		return userDAO.create(user);
	}
	
	
	private boolean validateUsername(String username) {
		return !(userDAO.fetchUsername(username) == null);
	}
	
	
	public boolean login(String username, String password) {
		
		if (!validateUsername(username)) {
			return false;
		}
		
		UserBean user = userDAO.fetchUsername(username);
		
		return user.getPassword().equals(password);
	}
}
