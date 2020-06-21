package br.com.movie.model.dao;

import java.util.List;

import br.com.movie.model.bean.MovieUserBean;
import br.com.movie.model.database.DBManager;
import br.com.movie.model.database.ObjectDAO;

public class MovieDAO implements ObjectDAO<MovieUserBean>{

	//Properties
	DBManager db = DBManager.shared();
	String table = "Movie_User";
	
	//Methods
	@Override
	public MovieUserBean fetchId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieUserBean fetchId(int id) {
		return db.select(table, Integer.toString(id), MovieUserBean.class);
	}

	@Override
	public List<MovieUserBean> fetchAll() {
		// TODO Auto-generated method stub
		return db.selectAll(table);
	}

	@Override
	public boolean update(MovieUserBean object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(MovieUserBean object) {
		return db.insert(object, table);
	}

	public List<MovieUserBean> fetchUserId(int id) {
		return db.selectAllByField(table, "user_id", Integer.toString(id));
	}
	
}
