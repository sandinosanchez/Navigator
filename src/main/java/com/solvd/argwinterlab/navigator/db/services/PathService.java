package com.solvd.argwinterlab.navigator.db.services;

import com.solvd.argwinterlab.navigator.db.dao.*;
import com.solvd.argwinterlab.navigator.db.dao.mysqlimpl.BusDao;
import com.solvd.argwinterlab.navigator.db.dao.mysqlimpl.PathDao;
import com.solvd.argwinterlab.navigator.db.dao.mysqlimpl.TaxiDao;
import com.solvd.argwinterlab.navigator.db.dao.mysqlimpl.TrainDao;
import com.solvd.argwinterlab.navigator.db.model.Path;
import com.solvd.argwinterlab.navigator.db.utils.ConnectionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PathService {
    private TaxiMapper taxiMapper;
    private BusMapper busMapper;
    private TrainMapper trainMapper;
    private PathMapper pathMapper;

    public PathService() {
        this.taxiMapper = new TaxiDao();
        this.busMapper =  new BusDao();
        this.trainMapper = new TrainDao();
        this.pathMapper = new PathDao();
    }

    public static List<Path> findAllByStationId(long id) {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            PathMapper pathMapper = session.getMapper(PathMapper.class);
            return pathMapper.findAllByStationId(id);
        }
    }

    public TaxiMapper getTaxiMapper() {
        return taxiMapper;
    }

    public void setTaxiMapper(TaxiMapper taxiMapper) {
        this.taxiMapper = taxiMapper;
    }

    public BusMapper getBusMapper() {
        return busMapper;
    }

    public void setBusMapper(BusMapper busMapper) {
        this.busMapper = busMapper;
    }

    public TrainMapper getTrainMapper() {
        return trainMapper;
    }

    public void setTrainMapper(TrainMapper trainMapper) {
        this.trainMapper = trainMapper;
    }

    public PathMapper getPathMapper() {
        return pathMapper;
    }

    public void setPathMapper(PathMapper pathMapper) {
        this.pathMapper = pathMapper;
    }
}
