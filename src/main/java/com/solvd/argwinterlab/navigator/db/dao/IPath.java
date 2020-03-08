package com.solvd.argwinterlab.navigator.db.dao;

import com.solvd.argwinterlab.navigator.db.model.Path;

public interface IPath extends IQuery<Path, Long> {

    Path findByStationId(long id);

    Path findByEntityId(long id);

}
