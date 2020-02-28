package com.solvd.argwinterlab.navigator.database.dao;

import java.util.List;

public interface IQuery<T> {
    T getById(long id);

    List<T> getAll();

    boolean deleteById(long id);

    boolean updateById(long id);
}
