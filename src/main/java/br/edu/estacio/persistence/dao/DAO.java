package br.edu.estacio.persistence.dao;

import java.util.List;

public interface DAO<T> {

	public void create(T t);
	
	public T read(long codigo);
	
	public List<T> readAll();
	
	public void update(T t);
	
	public void delete(long codigo);
	
}
