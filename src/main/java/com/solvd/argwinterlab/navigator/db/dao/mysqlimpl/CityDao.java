//package com.solvd.argwinterlab.navigator.db.dao.mysqlimpl;
//
//import com.solvd.argwinterlab.navigator.db.dao.CityMapper;
//import com.solvd.argwinterlab.navigator.db.model.City;
//import com.solvd.argwinterlab.navigator.db.utils.ClosableEntity;
//import static com.solvd.argwinterlab.navigator.db.utils.SqlConnection.getConnection;
//import org.apache.log4j.Logger;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CityDao extends AbstractDao implements CityMapper {
//    private static final Logger LOGGER = Logger.getLogger(StationDao.class);
//    private static final String GET_ALL = "SELECT * FROM Cities";
//    private static final String GET_BY_ID = "SELECT * FROM Cities WHERE id = ?";
//    private static final String DELETE_BY_ID = "DELETE FROM CITIES WHERE ID = ?";
//    private static final String UPDATE_BY_ID = "UPDATE CITIES SET ? = ? WHERE ID = ?";
//
//    @Override
//    public City findById(Long id) {
//        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
//            ResultSet rs = ce.executeQuery(GET_BY_ID, id);
//            if (rs.next()) return initializeCity(rs);
//        } catch (SQLException e) {
//            LOGGER.error(e);
//        }
//        return null;
//    }
//
//    @Override
//    public List<City> findAll() {
//        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
//            ResultSet rs = ce.executeQuery(GET_ALL);
//            List<City> cities = new ArrayList<>();
//            if (rs.next()) {
//                while (rs.next()) cities.add(initializeCity(rs));
//                return cities;
//            } else throw new SQLException("Not found");
//        } catch (SQLException e) {
//            LOGGER.error(e);
//        }
//        return null;
//    }
//
//    @Override
//    public boolean deleteById(Long id) {
//        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
//            ce.executeDelete(DELETE_BY_ID, id);
//            return true;
//        } catch (SQLException e) {
//            LOGGER.error(e);
//        }
//        return false;
//    }
//
//    @Override
//    public boolean updateById(Long id) {
//        try (ClosableEntity ce = new ClosableEntity(getConnection())) {
//            ce.executeDelete(UPDATE_BY_ID, id);
//            return true;
//        } catch (SQLException e) {
//            LOGGER.error(e);
//        }
//        return false;
//    }
//
//    @Override
//    public Long save(City entity) {
//        return null;
//    }
//
//    private City initializeCity(ResultSet rs) throws SQLException {
//        return new City(rs.getLong("ID"),
//                rs.getString("NAME"));
//    }
//}
