package com.solvd.argwinterlab.navigator.database.dao.mysqlimpl;

import com.solvd.argwinterlab.navigator.database.dao.ITrain;
import com.solvd.argwinterlab.navigator.database.model.Train;
import com.solvd.argwinterlab.navigator.database.utils.ClosableEntity;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.argwinterlab.navigator.database.utils.SqlConnection.getConnection;

public class TrainDao extends AbstractDao implements ITrain {
    private static final Logger LOGGER = Logger.getLogger(StationDao.class);
    private static final String FIND_ALL = "SELECT * FROM TRAINS";
    private static final String FIND_BY_ID = "SELECT * FROM TRAINS WHERE ID = ?";
    private static final String DELETE_BY_ID = "DELETE FROM TRAINS WHERE ID = ?";
    private static final String UPDATE_BY_ID = "UPDATE TRAINS SET ? = ? WHERE ID = ?";

    @Override
    public Train findById(Long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_BY_ID, id);
            if (rs.next()) return initializeTrain(rs);
            else throw new SQLException("Train with id " + id + " not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Train> findAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_ALL);
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
    public Long save(Train entity) {
        return null;
    }

    private Train initializeTrain(ResultSet rs) throws SQLException {
        return new Train(rs.getLong("ID"),
                rs.getString("MODEL"),
                rs.getLong("WEIGHT"),
                rs.getString("NAME"));
    }

}
