package com.solvd.argwinterlab.navigator.db;

import com.solvd.argwinterlab.navigator.db.dao.ICity;
import com.solvd.argwinterlab.navigator.db.dao.mysqlimpl.CityDao;
import com.solvd.argwinterlab.navigator.db.model.City;
import com.solvd.argwinterlab.navigator.db.utils.ConnectionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            ICity cityMapper = session.getMapper(ICity.class);
            List<City> cities = cityMapper.findAll();
            System.out.println(cities.toString());
        }
    }
}
