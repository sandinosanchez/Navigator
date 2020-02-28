package com.solvd.argwinterlab.navigator.database.dao.mysqlimpl;

import com.solvd.argwinterlab.navigator.database.dao.IPath;
import com.solvd.argwinterlab.navigator.database.model.City;
import com.solvd.argwinterlab.navigator.database.model.Path;
import com.solvd.argwinterlab.navigator.database.utils.ClosableEntity;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.argwinterlab.navigator.database.utils.SqlConnection.getConnectionFromPropertyFile;

public class PathDao extends AbstractDao implements IPath {
    private static final Logger LOGGER = Logger.getLogger(StationDao.class);
    private static final String GET_ALL = "SELECT * FROM Paths";
    private static final String GET_BY_ID = "SELECT * FROM Paths WHERE id = ?";
    private static final String DELETE_BY_ID = "";
    private static final String UPDATE_BY_ID = "";

    @Override
    public Path getById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnectionFromPropertyFile())) {
            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
            if (rs.next()) return initializePath(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Path> getAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnectionFromPropertyFile())) {
            ResultSet rs = ce.executeQuery(GET_ALL);
            List<Path> paths = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) paths.add(initializePath(rs));
                return paths;
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

    private Path initializePath(ResultSet rs) throws SQLException {
        return new Path(rs.getLong("id"));
    }
}
