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
	
	// Methods
	/**
	 * Cadastrar usuário.
	 * @param username Username do novo usuário.
	 * @param name Name do novo usuário.
	 * @param password Password do novo usuário..
	 * @return Boolean se o registro foi concluído.
	*/
	public boolean createNewUser(String username, String name, String password){
		if (!validateUsername(username)) {
			return false;
		}
		
		UserBean user = new UserBean(username, name, password);
		return userDAO.create(user);
	}
	
	
	/**
	 * Validação dos dados do cadastro de nova senha.
	 * @param username Username do usuário.
	 * @param name Name do usuário.
	 * @param password Nova password do usuário.
	 * @param repeatPassword Confirmação da nova password do usuário.
	 * @return Boolean se os dados foram preenchidos corretamente.
	*/
	public String validadeNewPasswordEntries(String name, String username, String password, String repeatPassword) {
		if (!validateUsername(username) || !validateName(name)) {
			return "Username ou Name não encontrados";
		}
		if (name == "" || username == "" || password == "") {
			return "Preencha todos os campos!";
		}
		if (!password.equals(repeatPassword)) {
			return "Passwords não são os mesmos.";
		}
		return null;
	}
	
	
	/**
	 * Trocar senha de usuário no banco.
	 * @param name Name do usuário.
	 * @param newPassword Nova password do usuário.
	 * @return Boolean se a alteração de senha foi concluída.
	*/
	public boolean changePassword(String name, String newPassword) {
		String predicate = "name = '" + name + "'";
		
		return userDAO.update("password", predicate, newPassword);
	}
	
	
	/**
	 * Verificar se usuário existe no banco.
	 * @param username Username do usuário.
	 * @return Boolean se usuário existe.
	*/
	private boolean validateUsername(String username) {
		return userDAO.fetchUsername(username) != null;
	}
	
	
	/**
	 * Verificar se usuário existe no banco.
	 * @param name Name do usuário.
	 * @return Boolean se usuário existe.
	*/
	private boolean validateName(String name) {
		return userDAO.fetchName(name) == null;
	}
	
	
	/**
	 * Fazer login do usuário.
	 * @param username Username do usuário.
	 * @param password Password do usuário.
	 * @return Boolean se o loggin foi concluído.
	*/
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
