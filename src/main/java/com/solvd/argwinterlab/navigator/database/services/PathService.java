package com.solvd.argwinterlab.navigator.database.services;

import com.solvd.argwinterlab.navigator.database.dao.IPath;
import com.solvd.argwinterlab.navigator.database.dao.IStation;
import com.solvd.argwinterlab.navigator.database.dao.ITrain;
import com.solvd.argwinterlab.navigator.database.dao.mysqlimpl.PathDao;
import com.solvd.argwinterlab.navigator.database.dao.mysqlimpl.StationDao;
import com.solvd.argwinterlab.navigator.database.dao.mysqlimpl.TrainDao;
import com.solvd.argwinterlab.navigator.database.model.Path;

import java.util.List;

public class PathService {
    private IStation stationDao;
    private ITrain trainDao;
    private IPath pathDao;

    public PathService() {
        this.stationDao = new StationDao();
        this.trainDao = new TrainDao();
        this.pathDao = new PathDao();
    }



}
