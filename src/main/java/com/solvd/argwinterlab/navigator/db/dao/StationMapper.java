package com.solvd.argwinterlab.navigator.db.dao;

import com.solvd.argwinterlab.navigator.db.model.Station;

import java.util.List;

public interface StationMapper {

    Station findById(long id);

    Station findByName(String name);

    List<Station> findAllByCityId(long id);

    List<Station> findAll();

    void updateById(Station station);

    void deleteById(long id);

}
