package br.com.movie.model.database;

import java.util.List;

public interface ObjectDAO<T> {
	
	T fetchId(String id);
	T fetchId(int id);
	List<T>fetchAll();
	boolean update(T object);
	boolean create(T object);
}
