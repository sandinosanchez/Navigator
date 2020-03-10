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

    public static IBus getBusMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(IBus.class);
    }

    public static ICity getCityMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(ICity.class);
    }

    public static IPath getPathMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(IPath.class);
    }

    public static ITaxi getTaxiMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(ITaxi.class);
    }

    public static ITrain getTrainMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(ITrain.class);
    }

    public static IStation getStationMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(IStation.class);
    }
}
