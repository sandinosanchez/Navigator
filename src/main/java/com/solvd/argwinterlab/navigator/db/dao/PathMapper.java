package com.solvd.argwinterlab.navigator.db.dao;

import com.solvd.argwinterlab.navigator.db.model.Path;

public interface PathMapper {

    Path findById(long id);

    Path findByStationId(long id);

    Path findByEntityId(long id);

}
