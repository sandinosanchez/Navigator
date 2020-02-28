package com.solvd.argwinterlab.navigator.database.dao.mysqlimpl;

import com.solvd.argwinterlab.navigator.database.dao.ITrain;
import com.solvd.argwinterlab.navigator.database.model.Station;
import com.solvd.argwinterlab.navigator.database.model.Train;
import com.solvd.argwinterlab.navigator.database.utils.ClosableEntity;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.argwinterlab.navigator.database.utils.SqlConnection.getConnectionFromPropertyFile;

public class TrainDao extends AbstractDao implements ITrain {
    private static final Logger LOGGER = Logger.getLogger(StationDao.class);
    private static final String GET_ALL = "SELECT * FROM Trains";
    private static final String GET_BY_ID = "SELECT * FROM Trains WHERE id = ?";
    private static final String DELETE_BY_ID = "";
    private static final String UPDATE_BY_ID = "";

    @Override
    public Train getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionFromPropertyFile())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializeTrain(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Train> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionFromPropertyFile())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Train> trains = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) trains.add(initializeTrain(rs));
                return trains;
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

    private Train initializeTrain(ResultSet rs) throws SQLException {
        return new Train(rs.getLong("id"),
                rs.getString("name"),
                rs.getString("number"));
    }
}
