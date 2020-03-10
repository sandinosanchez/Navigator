//package com.solvd.argwinterlab.navigator.db.services;
//
//import com.solvd.argwinterlab.navigator.db.dao.*;
//import com.solvd.argwinterlab.navigator.db.dao.mysqlimpl.BusDao;
//import com.solvd.argwinterlab.navigator.db.dao.mysqlimpl.PathDao;
//import com.solvd.argwinterlab.navigator.db.dao.mysqlimpl.StationDao;
//import com.solvd.argwinterlab.navigator.db.dao.mysqlimpl.TrainDao;
//
//public class PathService {
//    private IStation stationDao;
//    private ITrain trainDao;
//    private IBus busDao;
//    private PathMapper pathDao;
//
//    public PathService() {
//        this.stationDao = new StationDao();
//        this.trainDao = new TrainDao();
//        this.pathDao = new PathDao();
//        this.busDao = new BusDao();
//    }
//
////    public Path findById(long id) {
////        return pathDao
////                .findById(id)
////                .addEntity(trainDao.findById(id))
////                .addEntity(busDao.findById(id))
////                .setDestiny(stationDao.findById());
////    }
//
//    public IStation getStationDao() {
//        return stationDao;
//    }
//
//    public void setStationDao(IStation stationDao) {
//        this.stationDao = stationDao;
//    }
//
//    public PathMapper getPathDao() {
//        return pathDao;
//    }
//
//    public void setPathDao(PathMapper pathDao) {
//        this.pathDao = pathDao;
//    }
//
//    public IBus getBusDao() {
//        return busDao;
//    }
//
//    public void setBusDao(IBus busDao) {
//        this.busDao = busDao;
//    }
//}
