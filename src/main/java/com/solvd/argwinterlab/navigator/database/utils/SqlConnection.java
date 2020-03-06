package com.solvd.argwinterlab.navigator.database.utils;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

public class SqlConnection {
    private static Logger LOGGER = Logger.getLogger(SqlConnection.class);

    public static Connection getConnection() {
        try {
            Properties jdbcProperties = new Properties();
            jdbcProperties.load(new FileInputStream("src/main/resources/jdbc.properties"));
            return DriverManager.getConnection(jdbcProperties.getProperty("jdbc.conn.url"),
                    jdbcProperties.getProperty("jdbc.username"),
                    jdbcProperties.getProperty("jdbc.password"));
        } catch (IOException | SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

}
