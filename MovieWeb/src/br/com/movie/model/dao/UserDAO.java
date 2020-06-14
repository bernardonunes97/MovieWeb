package br.com.movie.model.dao;

import java.util.List;

import br.com.movie.model.bean.UserBean;
import br.com.movie.model.database.DBManager;
import br.com.movie.model.database.ObjectDAO;

public class UserDAO implements ObjectDAO<UserBean> {
	
	DBManager db = DBManager.shared();
	String table = "User";

	@Override
	public UserBean fetchId(String id) {
		return db.select("User", id, UserBean.class);
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

	@Override
	public boolean create(UserBean object) {
		db.insert(object, table);
		return false;
	}
	
	public UserBean fetchUsername(String username) {
		return db.selectByField(table, "username", username);
	}
}
