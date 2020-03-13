package com.solvd.argwinterlab.navigator;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisSession {
    private static final Logger LOGGER = Logger.getLogger(MyBatisSession.class);
    private SqlSession session;

    public SqlSession getSession() {
        if (session == null) {
            try {
                String resource = "mybatis-config.xml";
                InputStream inputStream = Resources.getResourceAsStream(resource);
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                session = sqlSessionFactory.openSession();
            } catch (IOException e) {
                LOGGER.error(e);
            }
        }
        return session;
    }

    @AfterClass
    private void close(){
        session.close();
    }
}
