package br.com.movie.model.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.movie.model.bean.UserBean;

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
	
	
	/**
	 * Operação Select no banco.
	 * @param table nome da tabela a ser acessada.
	 * @param id da linha.
	 * @param object classe modelo da entidade.
	 * @return o objeto resultado do select.
	*/
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
	/**
	 * Operação Select no banco.
	 * @param table nome da tabela a ser acessada.
	 * @return todos as linhas da tabela.
	*/
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
	
	@SuppressWarnings("unchecked")
	/**
	 * Operação Select no banco.
	 * @param table nome da tabela a ser acessada.
	 * @param condition predicate para fazer o select
	 * @return objetos resultado da opercao select.
	*/
	public <T>List<T> selectAllByField(String table, String condition) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(table);	
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		List<T> list = manager.createQuery("SELECT c FROM " + table + " c WHERE c." + condition).getResultList();
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * Operação Select no banco.
	 * @param table nome da tabela a ser acessada.
	 * @param field coluna para filtrar a tabela
	 * @param value valor desejado
	 * @return objetos resultado da opercao select.
	*/
	public <T>T selectByField(String table, String field, String value) {
		
		T result = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(table);	
		EntityManager manager = factory.createEntityManager();
		
		try {
			result = (T)manager.createQuery
					("SELECT c FROM " + table + " c WHERE c." + field + " = " + "'" + value + "'")
					.getSingleResult();
		} catch (Exception e) {}
		
		System.out.println("++++RESULT: " + result);
		return result;
	}
	
	
	/**
	 * Operação Insert no banco.
	 * @param obejct objeto a ser inserido
	 * @param table tabela para fazer a inserção
	 * @return Boolean que indica se a operacao foi concluida.
	*/
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
	
	/**
	 * Operação update no banco.
	 * @param table tabela para fazer o update
	 * @param column coluna que sofrera a alteração
	 * @param newValue novo valor a ser atribuído
	 * @param predicate condição para achar objeto que deve ser atualizado
	 * @return Boolean que indica se a operacao foi concluida.
	*/
	public<T> boolean update(String table, String column, String newValue, String predicate) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(table);	
		EntityManager manager = factory.createEntityManager();
		
		String query =
				"Update " + table + 
				" SET " + column + " = " + newValue +
				" WHERE " + predicate;
		
		manager.getTransaction().begin();
		manager.createQuery(query).executeUpdate();
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		return true;
		
	}
}

