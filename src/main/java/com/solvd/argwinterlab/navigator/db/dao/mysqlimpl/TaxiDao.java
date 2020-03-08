package com.solvd.argwinterlab.navigator.db.dao.mysqlimpl;

import com.solvd.argwinterlab.navigator.db.dao.ITaxi;
import com.solvd.argwinterlab.navigator.db.model.Taxi;
import org.apache.log4j.Logger;

import java.util.List;

public class TaxiDao extends AbstractDao implements ITaxi {
    private static final Logger LOGGER = Logger.getLogger(TaxiDao.class);
    private static final String FIND_ALL = "";
    private static final String FIND_BY_ID = "";
    private static final String DELETE_BY_ID = "";
    private static final String UPDATE_BY_ID = "";
    private static final String SAVE = "";

    @Override
    public Taxi findById(Long id) {
        return null;
    }

    @Override
    public List<Taxi> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean updateById(Long id) {
        return false;
    }

    @Override
    public Long save(Taxi entity) {
        return null;
    }
}
