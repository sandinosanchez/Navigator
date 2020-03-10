package com.solvd.argwinterlab.navigator.db.dao.mysqlimpl;

import com.solvd.argwinterlab.navigator.db.dao.IBus;
import com.solvd.argwinterlab.navigator.db.model.Bus;
import com.solvd.argwinterlab.navigator.db.utils.ClosableEntity;
import com.solvd.argwinterlab.navigator.db.utils.SqlConnection;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.argwinterlab.navigator.db.utils.SqlConnection.getConnection;

public class BusDao extends AbstractDao implements IBus {
    private static final Logger LOGGER = Logger.getLogger(BusDao.class);
    private static final String FIND_BY_ID = "SELECT * FROM BUSES WHERE ID = ?";
    private static final String FIND_ALL = "SELECT * FROM BUSES";
    private static final String FIND_BY_NAME = "SELECT * FROM BUSES WHERE NAME = ?";
    private static final String FIND_BY_MODEL = "SELECT * FROM BUSES WHERE MODEL = ?";
    private static final String DELETE_BY_ID = "DELETE FROM BUSES WHERE ID = ?";
    private static final String UPDATE_BY_ID = "UPDATE BUSES SET ? = ? WHERE ID = ?";

    @Override
    public Bus findById(Long id) {
        try (ClosableEntity ce = new ClosableEntity(SqlConnection.getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_BY_ID, id);
            if (rs.next()) return initializeBus(rs);
            else throw new SQLException("Bus with id " + id + " not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Bus> findAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_ALL);
            List<Bus> buses = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) buses.add(initializeBus(rs));
                return buses;
            } else throw new SQLException("Bus not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public Bus findByName(String name) {
        try (ClosableEntity ce = new ClosableEntity(SqlConnection.getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_BY_NAME, name);
            if (rs.next()) return initializeBus(rs);
            else throw new SQLException("Bus with name " + name + " not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public Bus findByModel(String model) {
        try (ClosableEntity ce = new ClosableEntity(SqlConnection.getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_BY_MODEL, model);
            if (rs.next()) return initializeBus(rs);
            else throw new SQLException("Bus with model " + model + " not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        try (ClosableEntity ce = new ClosableEntity(SqlConnection.getConnection())) {
            ce.executeDelete(DELETE_BY_ID, id);
            return true;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return false;
    }

    @Override
    public boolean updateById(Long id) {
        try (ClosableEntity ce = new ClosableEntity(SqlConnection.getConnection())) {
            ce.executeQuery(UPDATE_BY_ID, id);
            return true;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return false;
    }

    @Override
    public Long save(Bus entity) {
        return null;
    }

    private Bus initializeBus(ResultSet rs) throws SQLException {
        return new Bus(
                rs.getLong("ID"),
                rs.getString("MODEL"),
                rs.getInt("WEIGHT"),
                rs.getString("NAME"),
                rs.getString("LINE")
        );
    }

}
