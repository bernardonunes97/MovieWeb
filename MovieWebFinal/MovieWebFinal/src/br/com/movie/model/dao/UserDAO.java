package br.com.movie.model.dao;

import java.util.List;

import br.com.movie.model.bean.UserBean;
import br.com.movie.model.database.DBManager;
import br.com.movie.model.database.ObjectDAO;

public class UserDAO implements ObjectDAO<UserBean> {
	
	DBManager db = DBManager.shared();
	String table = "user";

	
	@Override
	/**
	 * Resgatar usuário do banco a partir do seu ID.
	 * @param id Id do usuário.
	 * @return Nada.
	*/
	public UserBean fetchId(String id) {
		return db.select(table, id, UserBean.class);
	}

	
	@Override
	/**
	 * Resgatar usuário do banco a partir do seu ID (overload).
	 * @param id Id do usuário.
	 * @return Nada.
	*/
	public UserBean fetchId(int id) {
		return db.select(table, Integer.toString(id), UserBean.class);
	}

	
	@Override
	/**
	 * Resgatar todos os usuário existentes no banco.
	 * @param Nenhum.
	 * @return List de todos os usuário existentes.
	*/
	public List<UserBean> fetchAll() {
		return db.selectAll(table);
	}
	
	
	@Override
	public boolean update(UserBean object) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	/**
	 * Inserir novo valor na coluna passada.
	 * @param column Coluna que terá seu valor alterado.
	 * @param predicate Expressão (true ou false) que corresponde à linha que será alterada.
	 * @param newValue Novo valor que será atribuído.
	 * @return Boolean se a alteração foi concluída.
	*/
	public boolean update(String column, String predicate, String newValue) {
		return db.update(table, column, newValue, predicate);
	}

	
	@Override
	/**
	 * Inserir novo usuário na tabela.
	 * @param object Usuário que será inserido.
	 * @return Boolean se a inserção foi concluída.
	*/
	public boolean create(UserBean object) {
		return db.insert(object, table);
	}
	
	
	/**
	 * Resgatar usuário do banco a partir do seu Username.
	 * @param username Username do usuário.
	 * @return Usuário.
	*/
	public UserBean fetchUsername(String username) {
		return db.selectByField(table, "username", username);
	}
	
	
	/**
	 * Resgatar usuário do banco a partir do seu Name.
	 * @param name Name do usuário.
	 * @return Usuário.
	*/
	public UserBean fetchName(String name) {
		return db.selectByField(table, "name", name);
	}
}
