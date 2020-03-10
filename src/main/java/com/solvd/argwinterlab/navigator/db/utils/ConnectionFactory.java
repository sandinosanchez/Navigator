package com.solvd.argwinterlab.navigator.db.utils;

import com.solvd.argwinterlab.navigator.db.dao.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class ConnectionFactory {
    private static SqlSessionFactory factory;

    static {
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }

    public static BusMapper getBusMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(BusMapper.class);
    }

    public static CityMapper getCityMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(CityMapper.class);
    }

    public static PathMapper getPathMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(PathMapper.class);
    }

    public static TaxiMapper getTaxiMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(TaxiMapper.class);
    }

    public static TrainMapper getTrainMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(TrainMapper.class);
    }

    public static StationMapper getStationMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(StationMapper.class);
    }
}
