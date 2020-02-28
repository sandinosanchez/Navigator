package com.solvd.argwinterlab.navigator.database.dao.mysqlimpl;

import com.solvd.argwinterlab.navigator.database.dao.ITrain;
import com.solvd.argwinterlab.navigator.database.model.Train;
import org.apache.log4j.Logger;

import java.util.List;

public class TrainDao extends AbstractDao implements ITrain {
    private static final Logger LOGGER = Logger.getLogger(StationDao.class);
    private static final String GET_ALL = "SELECT * FROM Trains";
    private static final String GET_BY_ID = "SELECT * FROM Trains WHERE id = ?";
    private static final String DELETE_BY_ID = "";
    private static final String UPDATE_BY_ID = "";

    @Override
    public Train getById(long id) {
        return null;
    }

    @Override
    public List<Train> getAll() {
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
