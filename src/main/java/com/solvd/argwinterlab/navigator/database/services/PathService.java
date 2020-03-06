package com.solvd.argwinterlab.navigator.database.services;

import com.solvd.argwinterlab.navigator.database.dao.*;
import com.solvd.argwinterlab.navigator.database.dao.mysqlimpl.BusDao;
import com.solvd.argwinterlab.navigator.database.dao.mysqlimpl.PathDao;
import com.solvd.argwinterlab.navigator.database.dao.mysqlimpl.StationDao;
import com.solvd.argwinterlab.navigator.database.dao.mysqlimpl.TrainDao;
import com.solvd.argwinterlab.navigator.database.model.Bus;
import com.solvd.argwinterlab.navigator.database.model.Path;

public class PathService {
    private IStation stationDao;
    private ITrain trainDao;
    private IBus busDao;
    private IPath pathDao;

    public PathService() {
        this.stationDao = new StationDao();
        this.trainDao = new TrainDao();
        this.pathDao = new PathDao();
        this.busDao = new BusDao();
    }

    public Path findById(long id) {
        return pathDao
                .findById(id)
                .addEntity(trainDao.findById(id))
                .addEntity(busDao.findById(id))
                .setDestiny(stationDao.findById());
    }

    public IStation getStationDao() {
        return stationDao;
    }

    public void setStationDao(IStation stationDao) {
        this.stationDao = stationDao;
    }

    public IPath getPathDao() {
        return pathDao;
    }

    public void setPathDao(IPath pathDao) {
        this.pathDao = pathDao;
    }

    public IBus getBusDao() {
        return busDao;
    }

    public void setBusDao(IBus busDao) {
        this.busDao = busDao;
    }
}
