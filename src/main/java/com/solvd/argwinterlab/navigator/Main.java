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
import org.apache.log4j.Logger;

public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            CityMapper cityMapper = session.getMapper(CityMapper.class);

            City city = cityMapper.findById(1);
            LOGGER.info(city.toString());

        }
    }
}
