package com.solvd.argwinterlab.navigator.database.dao;

import com.solvd.argwinterlab.navigator.database.model.Path;

public interface IPath extends IQuery<Path, Long> {

    Path findByStationId(long id);

    Path findByEntityId(long id);

}
