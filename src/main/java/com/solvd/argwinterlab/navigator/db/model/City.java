package com.solvd.argwinterlab.navigator.db.model;

import java.util.ArrayList;
import java.util.List;

public class City extends AbstractModel {
    private String name;
    private List<Station> stations = new ArrayList<>();

    public City() {}

    public City(long id, String name) {
        super(id);
        this.name = name;
    }

    public City(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object obj) {
        boolean equal = super.equals(obj);
        City city = (City) obj;
        if (!name.equals(city.name))
            equal = false;
        if (!stations.equals(city.stations))
            equal=false;
        return equal;
    }
}
