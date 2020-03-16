package com.solvd.argwinterlab.navigator.db.services;

import com.solvd.argwinterlab.navigator.db.dao.PathMapper;
import com.solvd.argwinterlab.navigator.db.dao.StationMapper;
import com.solvd.argwinterlab.navigator.db.dao.mysqlimpl.PathDao;
import com.solvd.argwinterlab.navigator.db.dao.mysqlimpl.StationDao;
import com.solvd.argwinterlab.navigator.db.model.Station;

import java.util.List;
import java.util.Objects;

public class StationService {
    private StationMapper stationMapper;
    private PathMapper pathMapper;

    public StationService() {
        this.stationMapper = new StationDao();
        this.pathMapper = new PathDao();
    }

    public Station findById(long id) {
        return stationMapper
                .findById(id)
                .setPaths(pathMapper.findAllByStationId(id));
    }

    public Station findByName(String name) {
        Station station = stationMapper.findByName(name);
        station.setPaths(pathMapper.findAllByStationId(station.getId()));
        return station;
    }

    public List<Station> findAll() {
        List<Station> stations = stationMapper.findAll();
        stations.forEach(s -> s.setPaths(pathMapper.findAllByStationId(s.getId())));
        return stations;
    }

    public void save(Station station) {
//        if (Objects.nonNull(station)) stationMapper.
    }

    public StationMapper getStationMapper() {
        return stationMapper;
    }

    public void setStationMapper(StationMapper stationMapper) {
        this.stationMapper = stationMapper;
    }

    public PathMapper getPathMapper() {
        return pathMapper;
    }

    public void setPathMapper(PathMapper pathMapper) {
        this.pathMapper = pathMapper;
    }
}
