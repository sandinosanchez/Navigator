package com.solvd.argwinterlab.navigator.db.dao;

import com.solvd.argwinterlab.navigator.db.model.City;

import java.util.List;

public interface CityMapper {
    City findById(long id);

    void updateById(City city);

    List<City> findAll();

    void save(City city);

    void deleteById(long id);
}
