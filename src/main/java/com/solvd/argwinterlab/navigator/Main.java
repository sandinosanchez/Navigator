package com.solvd.argwinterlab.navigator;

import com.solvd.argwinterlab.navigator.db.dao.CityMapper;
import com.solvd.argwinterlab.navigator.db.dao.PathMapper;
import com.solvd.argwinterlab.navigator.db.dao.StationMapper;
import com.solvd.argwinterlab.navigator.db.model.*;
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
            CityMapper cityMapper = session.getMapper(CityMapper.class);

            City cityA = new City();
            City cityB = new City();
            cityA.setName("A Land");
            cityB.setName("B Land");

            Train tr1 = new Train("Train 1");
            Train tr2 = new Train("Train 2");
            Train tr3 = new Train("Train 3");

            Bus bus1 = new Bus("Bus 1");
            Bus bus2 = new Bus("Bus 2");
            Bus bus3 = new Bus("Bus 3");

            cityA.addStation(new Station("A"));
            cityA.addStation(new Station("B"));
            cityA.addStation(new Station("C"));
            cityA.addStation(new Station("D"));
            cityA.addStation(new Station("E"));
            cityA.addStation(new Station("F"));
            cityA.addStation(new Station("H"));
            cityA.addStation(new Station("G"));

            cityB.addStation(new Station("I"));
            cityB.addStation(new Station("J"));
            cityB.addStation(new Station("K"));

            cityA.addPath("A","B",tr1);
            cityA.addPath("B","C",tr1);
            cityA.addPath("C","D",tr2);
            cityA.addPath("C","D",bus1);
            cityA.addPath("D","E",tr1);
            cityA.addPath("E","F",bus1);
            cityA.addPath("E","H",tr1);
            cityA.addPath("F","H",bus2);
            cityA.addPath("F","G",bus1);
            cityA.addPath("G","H",bus1);
            cityA.addPath("H","A",tr1);

            System.out.println(cityA);
            //System.out.println(cityB);
        }
    }
}
