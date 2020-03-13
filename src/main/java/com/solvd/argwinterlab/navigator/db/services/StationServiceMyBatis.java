package com.solvd.argwinterlab.navigator.db.services;

import com.solvd.argwinterlab.navigator.db.dao.PathMapper;
import com.solvd.argwinterlab.navigator.db.dao.StationMapper;
import com.solvd.argwinterlab.navigator.db.model.Path;
import com.solvd.argwinterlab.navigator.db.model.Station;
import com.solvd.argwinterlab.navigator.db.utils.ConnectionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StationServiceMyBatis {
    private SqlSession session;
    private PathMapper pathMapper;
    private StationMapper stationMapper;

    public StationServiceMyBatis() {
        session = ConnectionFactory.getSqlSessionFactory().openSession(true);
        pathMapper = session.getMapper(PathMapper.class);
        stationMapper = session.getMapper(StationMapper.class);
    }

//    public Station findById(long id) {
//        Station station = stationMapper.findById(id).setPaths(pathMapper.findAllByStationId(id));
//    }

    public static List<Station> findAll() {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            StationMapper stationMapper = session.getMapper(StationMapper.class);
            return stationMapper.findAll();
        }
    }
}
