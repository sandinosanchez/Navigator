package com.solvd.argwinterlab.navigator.db.dao.mysqlimpl;

import com.solvd.argwinterlab.navigator.db.dao.IStation;
import com.solvd.argwinterlab.navigator.db.model.Station;
import com.solvd.argwinterlab.navigator.db.utils.ClosableEntity;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.argwinterlab.navigator.db.utils.SqlConnection.getConnection;

public class StationDao extends AbstractDao implements IStation {
    private static final Logger LOGGER = Logger.getLogger(StationDao.class);
    private static final String FIND_ALL = "SELECT * FROM STATIONS";
    private static final String FIND_BY_ID = "SELECT * FROM STATIONS WHERE ID = ?";
    private static final String DELETE_BY_ID = "DELETE FROM STATIONS WHERE ID = ?";
    private static final String UPDATE_BY_ID = "UPDATE STATIONS SET ? = ? WHERE ID = ?";

    @Override
    public Station findById(Long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_BY_ID, id);
            if (rs.next()) return initializeStation(rs);
            else throw new SQLException("Station with id " + id + " not found.");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Station> findAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_ALL);
            List<Station> stations = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) stations.add(initializeStation(rs));
                return stations;
            } else throw new SQLException("Station not found.");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ce.executeDelete(DELETE_BY_ID, id);
            return true;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return false;
    }

    @Override
    public boolean updateById(Long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ce.executeDelete(UPDATE_BY_ID, id);
            return true;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return false;
    }

    @Override
    public Long save(Station entity) {
        return null;
    }

    private Station initializeStation(ResultSet rs) throws SQLException {
        return new Station(rs.getLong("id"),
                rs.getString("ADDRESS"),
                rs.getString("NAME"));
    }
}
