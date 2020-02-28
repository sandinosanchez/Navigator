package com.solvd.argwinterlab.navigator.database.dao.mysqlimpl;

import com.solvd.argwinterlab.navigator.database.dao.IStation;
import com.solvd.argwinterlab.navigator.database.model.Path;
import com.solvd.argwinterlab.navigator.database.model.Station;
import com.solvd.argwinterlab.navigator.database.utils.ClosableEntity;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.argwinterlab.navigator.database.utils.SqlConnection.getConnectionFromPropertyFile;

public class StationDao extends AbstractDao implements IStation {
    private static final Logger LOGGER = Logger.getLogger(StationDao.class);
    private static final String GET_ALL = "SELECT * FROM Stations";
    private static final String GET_BY_ID = "SELECT * FROM Stations WHERE id = ?";
    private static final String DELETE_BY_ID = "";
    private static final String UPDATE_BY_ID = "";

    @Override
    public Station getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionFromPropertyFile())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeStation(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Station> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionFromPropertyFile())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Station> stations = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) stations.add(initializeStation(rs));
                return stations;
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

    private Station initializeStation(ResultSet rs) throws SQLException {
        return new Station(rs.getLong("id"),
                rs.getString("address"),
                rs.getString("name"));
    }
}
