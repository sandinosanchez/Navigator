package com.solvd.argwinterlab.navigator.db.dao.mysqlimpl;

import com.solvd.argwinterlab.navigator.db.dao.PathMapper;
import com.solvd.argwinterlab.navigator.db.model.Path;
import com.solvd.argwinterlab.navigator.db.utils.ClosableEntity;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.argwinterlab.navigator.db.utils.SqlConnection.getConnection;

public class PathDao extends AbstractDao implements PathMapper {
    private static final Logger LOGGER = Logger.getLogger(PathDao.class);
    private static final String FIND_ALL = "SELECT * FROM PATHS";
    private static final String FIND_BY_ID = "SELECT * FROM PATHS WHERE id = ?";
    private static final String FIND_ALL_BY_STATION_ID = "SELECT * FROM PATHS WHERE STATION_ID = ?";
    private static final String FIND_BY_ENTITY_ID = "SELECT * FROM PATHS WHERE ENTITY_ID = ?";
    private static final String DELETE_BY_ID = "DELETE FROM PATHS WHERE ID = ?";
    private static final String UPDATE_BY_ID = "UPDATE PATHS SET ? = ? WHERE ID = ?";
    private static final String INSERT = "";

    @Override
    public Path findById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_BY_ID, id);
            if (rs.next()) return initializePath(rs);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Path> findAllByStationId(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_ALL_BY_STATION_ID, id);
            List<Path> paths = new ArrayList<>();
            if (rs.next()) {
                while (rs.next()) paths.add(initializePath(rs));
                return paths;
            } else throw new SQLException("Station with id " + id + " not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }


    @Override
    public Path findByEntityId(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_BY_ENTITY_ID, id);
            if (rs.next()) return initializePath(rs);
            else throw new SQLException("Entity with id " + id + " not found");
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Path> findAll() {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ResultSet rs = ce.executeQuery(FIND_ALL);
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
    public void deleteById(long id) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ce.executeDelete(DELETE_BY_ID, id);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void updateById(Path path) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ce.executeDelete(UPDATE_BY_ID, path.getId());
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void save(Path path) {
        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
            ce.executeQuery(INSERT);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    private Path initializePath(ResultSet rs) throws SQLException {
        return new Path(rs.getLong("ID"));
    }
}
