package com.solvd.argwinterlab.navigator.database.dao.mysqlimpl;

import com.solvd.argwinterlab.navigator.database.dao.IPath;
import com.solvd.argwinterlab.navigator.database.model.Path;
import org.apache.log4j.Logger;

import java.util.List;

public class PathDao extends AbstractDao implements IPath {
    private static final Logger LOGGER = Logger.getLogger(StationDao.class);
    private static final String GET_ALL = "SELECT * FROM Paths";
    private static final String GET_BY_ID = "SELECT * FROM Paths WHERE id = ?";
    private static final String DELETE_BY_ID = "";
    private static final String UPDATE_BY_ID = "";

    @Override
    public Path getById(long id) {
        return null;
    }

    @Override
    public List<Path> getAll() {
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
