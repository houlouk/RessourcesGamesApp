package com.topjavatutorial.dao;

import java.util.List;

public interface Dao<T> {

  public void add(T t);

  public int delete(int id);

  public T get(int id);

  public List<T> getAll();

  public int update(int id, T t);

}
