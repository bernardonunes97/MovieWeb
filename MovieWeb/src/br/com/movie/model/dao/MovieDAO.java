package br.com.movie.model.dao;

import java.util.List;

import br.com.movie.model.bean.MovieUserBean;
import br.com.movie.model.database.ObjectDAO;

public class MovieDAO implements ObjectDAO<MovieUserBean>{

	@Override
	public MovieUserBean fetchId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieUserBean fetchId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieUserBean> fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(MovieUserBean object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(MovieUserBean object) {
		// TODO Auto-generated method stub
		return false;
	}

}
