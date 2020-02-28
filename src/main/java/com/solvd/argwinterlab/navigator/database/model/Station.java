package com.solvd.argwinterlab.navigator.database.model;

import java.util.List;

public class Station extends AbstractModel {
    private String address;
    private String name;
    private List<Path> paths;

    private Station() {}

    public Station(String address, String name, List<Path> paths) {
        this.address = address;
        this.name = name;
        this.paths = paths;
    }

    public Station(long id, String address, String name, List<Path> paths) {
        super(id);
        this.address = address;
        this.name = name;
        this.paths = paths;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }
}
