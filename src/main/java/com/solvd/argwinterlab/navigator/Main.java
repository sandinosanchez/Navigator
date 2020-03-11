package com.solvd.argwinterlab.navigator;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.solvd.argwinterlab.navigator.db.dao.CityMapper;
import com.solvd.argwinterlab.navigator.db.utils.ConnectionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.solvd.argwinterlab.navigator.db.model.City;

public class Main {

    public static void main(String[] args) throws IOException {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
//            StationMapper stationMapper = session.getMapper(StationMapper.class);
//            PathMapper pathMapper = session.getMapper(PathMapper.class);
            CityMapper cityMapper = session.getMapper(CityMapper.class);

            City city = cityMapper.findById(1);
            System.out.println(city.toString());
//            List<Station> station = stationMapper.findAll();
//            System.out.println(station.toString());
//            Station station1 = stationMapper.findById(1);
//            System.out.println(station1.toString());
//            Path path = pathMapper.findById(1);
//            System.out.println(path.toString());
//
//            List<City> cities = cityMapper.findAll();
//            List<City> cities = session.selectList("cityMapper.findAll");
//            System.out.println(cities.toString());



        }


//
//            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
//    		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//    		SqlSession session = sqlSessionFactory.openSession();
//    		List<City> list = session.selectList("CityMapper.findAll");
//    		for (City city : list) {
//    			System.out.print(city.toString());
//    		}
//    		session.commit();
//    		session.close();
    }
}
