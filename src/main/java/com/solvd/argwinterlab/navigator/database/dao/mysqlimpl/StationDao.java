package com.solvd.argwinterlab.navigator.database.dao.mysqlimpl;

import com.solvd.argwinterlab.navigator.database.dao.IStation;
import com.solvd.argwinterlab.navigator.database.model.Station;
import org.apache.log4j.Logger;

import java.util.List;

public class StationDao extends AbstractDao implements IStation {
    private static final Logger LOGGER = Logger.getLogger(StationDao.class);
    private static final String GET_ALL = "SELECT * FROM Stations";
    private static final String GET_BY_ID = "SELECT * FROM Stations WHERE id = ?";
    private static final String DELETE_BY_ID = "";
    private static final String UPDATE_BY_ID = "";

    @Override
    public Station getById(long id) {
        return null;
    }

    @Override
    public List<Station> getAll() {
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public boolean updateById(long id) {
        return false;
    }
}
