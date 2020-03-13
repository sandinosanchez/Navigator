package com.solvd.argwinterlab.navigator;

import com.solvd.argwinterlab.navigator.db.dao.CityMapper;
import com.solvd.argwinterlab.navigator.db.model.City;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CRUDCity extends MyBatisSession {
    private CityMapper mapper = getSession().getMapper(CityMapper.class);

    @Test
    public void create(){
        City city = new City("City A");
        mapper.save(city);
        City retrievedCity = mapper.findById(city.getId());
        Assert.assertEquals(city,retrievedCity);
    }

    @Test
    public void update(){
        City city = new City("City B");
        mapper.save(city);
        city.setName("City C");
        mapper.updateById(city);
        City retrievedCity = mapper.findById(city.getId());
        Assert.assertEquals(city,retrievedCity);
    }

    @Test()
    public void delete(){
        City city = new City("City D");
        mapper.save(city);
        mapper.deleteById(city.getId());
        City retrievedCity = mapper.findById(city.getId());
        Assert.assertNull(retrievedCity);
    }

}
