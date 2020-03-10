package com.solvd.argwinterlab.navigator.db;

import com.solvd.argwinterlab.navigator.db.dao.CityMapper;
import com.solvd.argwinterlab.navigator.db.dao.PathMapper;
import com.solvd.argwinterlab.navigator.db.model.City;
import com.solvd.argwinterlab.navigator.db.model.Path;
import com.solvd.argwinterlab.navigator.db.utils.ConnectionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws IOException {
//        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
//            CityMapper cityMapper = session.getMapper(CityMapper.class);
//
//            City city = cityMapper.findById(1);
//            if (city == null)
//                System.out.println("null");
//            else
//                System.out.println(city.toString());
//        }
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();

        session.selectOne("CityMapper.findById", 1);

        session.commit();
        session.close();
    }
}
