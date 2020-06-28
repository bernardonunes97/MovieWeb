package br.com.movie.model.dao;

import java.util.List;

import br.com.movie.model.bean.UserBean;
import br.com.movie.model.database.DBManager;
import br.com.movie.model.database.ObjectDAO;

public class UserDAO implements ObjectDAO<UserBean> {
	
	DBManager db = DBManager.shared();
	String table = "user";

	@Override
	public UserBean fetchId(String id) {
		return db.select(table, id, UserBean.class);
	}

	@Override
	public UserBean fetchId(int id) {
		return db.select(table, Integer.toString(id), UserBean.class);
	}

	@Override
	public List<UserBean> fetchAll() {
		return db.selectAll(table);
	}
	
	@Override
	public boolean update(UserBean object) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean update(String column, String predicate, String newValue) {
		return db.update(table, column, newValue, predicate);
	}

	@Override
	public boolean create(UserBean object) {
		return db.insert(object, table);
	}
	
	public UserBean fetchUsername(String username) {
		return db.selectByField(table, "username", username);
	}
	
	public UserBean fetchName(String name) {
		return db.selectByField(table, "name", name);
	}
}
