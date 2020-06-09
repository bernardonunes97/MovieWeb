package br.com.movie.model.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBManager {
	
	public static DBManager dbManager = null;
	
	//Constructor sigleton
	private DBManager() {}
	
	//Methods
	public static DBManager shared() {
				
		if (dbManager == null) {
			dbManager = new DBManager();
		}
				
		return dbManager;
	}
	
	
	public <T>T select(String table, String id, Class<T> object) {
			
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(table);	
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		T user = manager.find(object, id);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		return user;
	}
	

	@SuppressWarnings("unchecked")
	public <T>List<T> selectAll(String table) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(table);	
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		List<T> list = manager.createQuery("select c FROM " + table + " c").getResultList();
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		return list;
	}
	
	public <T>boolean insert(T object, String table) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(table);	
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(object);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		return true;
	}
	
	public<T> boolean update(String table, String column, String predicate) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(table);	
		EntityManager manager = factory.createEntityManager();
		
		String query = "Update " + table + " SET " + column + " WHERE " + predicate;
		System.out.println(query);
		
		manager.getTransaction().begin();
		manager.createQuery(query).executeUpdate();
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		return true;
		
	}
}

