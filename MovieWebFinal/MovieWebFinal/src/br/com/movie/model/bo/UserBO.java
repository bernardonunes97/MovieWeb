package br.com.movie.model.bo;

import br.com.movie.model.bean.UserBean;
import br.com.movie.model.dao.UserDAO;

public class UserBO {
	
	//Properties
	private UserDAO userDAO;
	
	//Constructor
	public UserBO() {
		this.userDAO = new UserDAO();
	}
	
	//Methods
	boolean createNewUser(String username, String name, String password){
		if (!validateUsername(username)) {
			return false;
		}
		
		UserBean user = new UserBean(username, name, password);
		return userDAO.create(user);
	}
	
	private boolean validateUsername(String username) {
		if (userDAO.fetchUsername(username) == null) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean login(String username, String password) {
		if (!validateUsername(username)) {
			return false;
		}
		
		UserBean user = userDAO.fetchUsername(username);
		
		if(user.getPassword() == password) {
			return true;
		} else {
			return false;
		}	
	}
}