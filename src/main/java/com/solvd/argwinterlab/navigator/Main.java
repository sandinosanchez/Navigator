package com.solvd.argwinterlab.navigator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.solvd.argwinterlab.navigator.algorithm.PathSearch;
import com.solvd.argwinterlab.navigator.algorithm.Result;
import com.solvd.argwinterlab.navigator.db.dao.CityMapper;
import com.solvd.argwinterlab.navigator.db.dao.StationMapper;
import com.solvd.argwinterlab.navigator.db.model.City;
import com.solvd.argwinterlab.navigator.db.model.Station;
import com.solvd.argwinterlab.navigator.db.utils.ConnectionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            StationMapper stationMapper = session.getMapper(StationMapper.class);
            CityMapper cityMapper = session.getMapper(CityMapper.class);

            Station station1 = stationMapper.findById(1);
            Station station2 = stationMapper.findById(3);

            try (Writer writer = new FileWriter("output.json")) {
                Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
                //List<Result> resultList = PathSearch.getPath(station1, station2, session);
                gson.toJson(cityMapper.findAll(), writer);
            } catch (IOException e) {
                LOGGER.error(e);
            }
        }
    }
}
