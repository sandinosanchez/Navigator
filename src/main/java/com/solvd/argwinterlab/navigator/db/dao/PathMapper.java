package com.solvd.argwinterlab.navigator.db.dao;

import com.solvd.argwinterlab.navigator.db.model.Path;

import java.util.List;

public interface PathMapper {

    Path findById(long id);

    List<Path> findAllByStationId(long id);

    Path findByEntityId(long id);

    List<Path> findAll();

    void updateById(Path path);

    void deleteById(long id);

    void save(Path path);

}
