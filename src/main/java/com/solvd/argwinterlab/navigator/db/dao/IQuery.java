package com.solvd.argwinterlab.navigator.db.dao;

import java.util.List;

public interface IQuery<T,E> {
    T findById(E id);

    List<T> findAll();

    boolean deleteById(E id);

    boolean updateById(E id);

    E save(T entity);
}
