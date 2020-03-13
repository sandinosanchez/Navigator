package com.solvd.argwinterlab.navigator.db.model;

import java.util.ArrayList;
import java.util.List;

public class City extends AbstractModel {
    private String name;
    private List<Station> stations;

    public City() {}

    public City(long id, String name) {
        super(id);
        this.name = name;
        this.stations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public City setStations(List<Station> stations) {
        this.stations = stations;
        return this;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", stations=" + stations.toString() +
                '}';
    }
}
