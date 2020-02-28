package com.solvd.argwinterlab.navigator.database.utils;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ClosableEntity implements AutoCloseable {
    private static final Logger LOGGER = Logger.getLogger(ClosableEntity.class);
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement statement;

    public ClosableEntity(Connection connection) {
        this.connection = connection;
    }

    public ResultSet executeQuery(String query) throws SQLException {
        LOGGER.info("Executing query: " + query);
        resultSet = connection.prepareStatement(query).executeQuery();
        return resultSet;
    }

    public ResultSet executeQuery(String query, long id) throws SQLException {
        statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        LOGGER.info("Executing query:" + statement.toString());
        return statement.executeQuery();
    }

    public void executeDelete(String query, long id) throws SQLException {
        statement = connection.prepareStatement(query);
        statement.setLong(1, id);
        LOGGER.info("Executing query:" + statement.toString());
        statement.executeQuery();
    }


    @Override
    public void close() {
        try {
            if (Objects.nonNull(statement))
                statement.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public PreparedStatement getStatement() {
        return statement;
    }

    public void setStatement(PreparedStatement statement) {
        this.statement = statement;
    }
}
