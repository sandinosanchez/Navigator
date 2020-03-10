package com.solvd.argwinterlab.navigator.db.dao;

import com.solvd.argwinterlab.navigator.db.model.Station;

import java.util.List;

public interface StationMapper {

    Station findById(long id);

    Station findByCityId(long id);

    List<Station> findAll();

}
