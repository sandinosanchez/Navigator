package com.solvd.argwinterlab.navigator.db.dao.mysqlimpl;

import com.solvd.argwinterlab.navigator.db.dao.StationMapper;
import com.solvd.argwinterlab.navigator.db.model.Station;
import com.solvd.argwinterlab.navigator.db.utils.ClosableEntity;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.argwinterlab.navigator.db.utils.SqlConnection.getConnection;

public class StationDao extends AbstractDao implements StationMapper {
    private static final Logger LOGGER = Logger.getLogger(StationDao.class);
    private static final String FIND_ALL = "SELECT * FROM STATIONS";
    private static final String FIND_BY_ID = "SELECT * FROM STATIONS WHERE ID = ?";
    private static final String FIND_ALL_BY_CITY_ID = "SELECT * FROM STATIONS WHERE CITY_ID = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM STATIONS WHERE NAME = ?";
    private static final String DELETE_BY_ID = "DELETE FROM STATIONS WHERE ID = ?";
    private static final String UPDATE_BY_ID = "UPDATE STATIONS SET ? = ? WHERE ID = ?";

    @Override
    public Station findById(long id) {
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
    public Station findByName(String name) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_BY_NAME, name);
            if (rs.next()) return initializeStation(rs);
            else throw new SQLException("Station with name " + name + " not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public Station findSimpleStationById(long id) {
        return null;
    }

    @Override
    public List<Station> findAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_ALL);
            List<Station> stations = new ArrayList<>();
            if (rs.next()) {
//                while (rs.next()) stations.add(initializeStation(rs));
                return stations;
            } else throw new SQLException("Station not found.");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Station> findAllByCityId(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_ALL_BY_CITY_ID, id);
            List<Station> stations = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) stations.add(initializeStation(rs));
                return stations;
            } else throw new SQLException("Stations not found");
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
    public void updateById(Station station) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ce.executeDelete(UPDATE_BY_ID, station.getId());
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    private Station initializeStation(ResultSet rs) throws SQLException {
        return new Station(rs.getLong("id"),
                rs.getString("ADDRESS"),
                rs.getString("NAME"));
    }
}
