package com.solvd.argwinterlab.navigator;

import com.solvd.argwinterlab.navigator.db.dao.CityMapper;
import com.solvd.argwinterlab.navigator.db.dao.PathMapper;
import com.solvd.argwinterlab.navigator.db.dao.StationMapper;
import com.solvd.argwinterlab.navigator.db.model.City;
import com.solvd.argwinterlab.navigator.db.model.Path;
import com.solvd.argwinterlab.navigator.db.model.Station;
import com.solvd.argwinterlab.navigator.db.utils.ConnectionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            StationMapper stationMapper = session.getMapper(StationMapper.class);
            PathMapper pathMapper = session.getMapper(PathMapper.class);
            CityMapper cityMapper = session.getMapper(CityMapper.class);

//            City city = cityMapper.findById(1);
//            System.out.println(city.toString());
////            List<Station> station = stationMapper.findAll();
////            System.out.println(station.toString());
//            Station station1 = stationMapper.findById(1);
//            System.out.println(station1.toString());
            Path path = pathMapper.findById(1);
            System.out.println(path.toString());

        }
//        Reader reader = Resources.getResourceAsReader("mappers/mybatis-config.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        SqlSession session = sqlSessionFactory.openSession();
//        System.out.println(session.toString());
//        System.out.println(session.getConnection().toString());
//
//        System.out.println(session.selectOne("com.solvd.argwinterlab.navigator.db.dao.CityMapper.findById", 1).toString());
//
//        session.commit();
//        session.close();
    }
}
