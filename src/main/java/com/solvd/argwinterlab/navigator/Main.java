package com.solvd.argwinterlab.navigator;

import com.solvd.argwinterlab.navigator.db.dao.CityMapper;
import com.solvd.argwinterlab.navigator.db.utils.ConnectionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            CityMapper cityMapper = session.getMapper(CityMapper.class);
            LOGGER.info(cityMapper.findAll());
        }
    }
}
