package com.solvd.argwinterlab.navigator.db.services;

import com.solvd.argwinterlab.navigator.db.dao.CityMapper;
import com.solvd.argwinterlab.navigator.db.dao.StationMapper;
import com.solvd.argwinterlab.navigator.db.dao.mysqlimpl.CityDao;
import com.solvd.argwinterlab.navigator.db.dao.mysqlimpl.StationDao;
import com.solvd.argwinterlab.navigator.db.model.City;

import java.util.List;
import java.util.Objects;

public class CityService {
    private CityMapper cityMapper;
    private StationMapper stationMapper;

    public CityService() {
        this.cityMapper = new CityDao();
        this.stationMapper = new StationDao();
    }

    public City findById(long id) {
        return cityMapper
                .findById(id)
                .setStations(stationMapper.findAllByCityId(id));
    }

    public List<City> findAll() {
        List<City> cities = cityMapper.findAll();
        cities.forEach(c -> c.setStations(stationMapper.findAllByCityId(c.getId())));
        return cities;
    }

    public City findByName(String name) {
        City city = cityMapper.findByName(name);
        city.setStations(stationMapper.findAllByCityId(city.getId()));
        return city;
    }

    public void save(City city) {
        if (Objects.nonNull(city)) cityMapper.save(city);
    }

    public void deleteById(long id) {
        if (id > 0) cityMapper.deleteById(id);
    }

    public void updateById(City city) {

    }

    public CityMapper getCityMapper() {
        return cityMapper;
    }

    public void setCityMapper(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    public StationMapper getStationMapper() {
        return stationMapper;
    }

    public void setStationMapper(StationMapper stationMapper) {
        this.stationMapper = stationMapper;
    }
}
