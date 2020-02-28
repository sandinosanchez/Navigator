package com.solvd.argwinterlab.navigator.database.dao.mysqlimpl;

import com.solvd.argwinterlab.navigator.database.dao.ICity;
import com.solvd.argwinterlab.navigator.database.model.City;
import com.solvd.argwinterlab.navigator.database.utils.ClosableEntity;
import static com.solvd.argwinterlab.navigator.database.utils.SqlConnection.getConnectionFromPropertyFile;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDao extends AbstractDao implements ICity {
    private static final Logger LOGGER = Logger.getLogger(StationDao.class);
    private static final String GET_ALL = "SELECT * FROM Cities";
    private static final String GET_BY_ID = "SELECT * FROM Cities WHERE id = ?";
    private static final String DELETE_BY_ID = "";
    private static final String UPDATE_BY_ID = "";

    @Override
    public City getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionFromPropertyFile())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeCity(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<City> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionFromPropertyFile())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<City> cities = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) cities.add(initializeCity(rs));
                return cities;
            } else throw new SQLException("Not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionFromPropertyFile())) {
            ce.executeDelete(DELETE_BY_ID, id);
            return true;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return false;
    }

    @Override
    public boolean updateById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionFromPropertyFile())) {
            ce.executeDelete(DELETE_BY_ID, id);
            return true;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return false;
    }

    private City initializeCity(ResultSet rs) throws SQLException {
        return new City(rs.getLong("id"),
                rs.getString("name"));
    }
}
