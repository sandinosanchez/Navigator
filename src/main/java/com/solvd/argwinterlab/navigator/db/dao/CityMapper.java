package com.solvd.argwinterlab.navigator.db.dao;

import java.util.List;

import com.solvd.argwinterlab.navigator.db.model.City;

public interface CityMapper {
    City findById(long id);

    City findByName(String name);

    List<City> findAll();

    void updateById(City city);

    void save(City city);

    void deleteById(long id);

}
