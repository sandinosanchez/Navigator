package com.solvd.argwinterlab.navigator.db.dao.mysqlimpl;

import com.solvd.argwinterlab.navigator.db.dao.CityMapper;
import com.solvd.argwinterlab.navigator.db.model.City;
import com.solvd.argwinterlab.navigator.db.utils.ClosableEntity;
import static com.solvd.argwinterlab.navigator.db.utils.SqlConnection.getConnection;
import org.apache.log4j.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDao extends AbstractDao implements CityMapper {
    private static final Logger LOGGER = Logger.getLogger(CityDao.class);
    private static final String FIND_ALL = "SELECT * FROM CITIES";
    private static final String FIND_BY_ID = "SELECT * FROM CITIES WHERE id = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM CITIES WHERE NAME = ?";
    private static final String DELETE_BY_ID = "DELETE FROM CITIES WHERE ID = ?";
    private static final String UPDATE_BY_ID = "UPDATE CITIES SET ? = ? WHERE ID = ?";
    private static final String INSERT = "INSERT INTO CITIES (NAME) VALUES (?)";

    @Override
    public City findById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_BY_ID, id);
            if (rs.next()) return initializeCity(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public City findByName(String name) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_BY_NAME, name);
            if (rs.next()) return initializeCity(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<City> findAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_ALL);
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
    public void deleteById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ce.executeDelete(DELETE_BY_ID, id);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void updateById(City city) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ce.executeDelete(UPDATE_BY_ID, city.getId());
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void save(City city) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ce.executeQuery(INSERT, city.getName());
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    private City initializeCity(ResultSet rs) throws SQLException {
        return new City(rs.getLong("ID"),
                rs.getString("NAME"));
    }
}
