package com.Dao;

import java.util.List;

public interface Dao<T> {

	public List<T> findAll();
	public T findByName(String name);
	public T findElem(T elem);
}
