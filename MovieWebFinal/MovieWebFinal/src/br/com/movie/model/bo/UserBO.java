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
	
	public boolean validadeNewPasswordEntries(String username, String name, String password, String repeatPassword) {
		if (!validateUsername(username) || !validateName(name)) {
			return false;
		}
		return true;
	}
	
	
	public boolean changePassword(String name, String newPassword) {
		String predicate = "name = '" + name + "'";
		
		return userDAO.update("password", predicate, newPassword);
	}
	
	
	private boolean validateUsername(String username) {
		return userDAO.fetchUsername(username) != null;
	}
	
	
	private boolean validateName(String name) {
		return userDAO.fetchName(name) == null;
	}
	
	
	public boolean login(String username, String password) {
		
		// Para não fazer duas requisições no banco.
//		if (!validateUsername(username)) {
//			return false;
//		}
		UserBean user = userDAO.fetchUsername(username);
		
		if (user != null) {
			return user.getPassword().equals(password);
		} else {
			return false;
		}
	}
}
