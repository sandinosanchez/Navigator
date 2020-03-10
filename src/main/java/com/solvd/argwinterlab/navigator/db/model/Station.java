package com.solvd.argwinterlab.navigator.db.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Station extends AbstractModel {
    private String address;
    private String name;
    private List<Path> paths;

    private Station() {}


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

    @Override
    public String toString() {
        String result;
        if (paths == null) {
            result = "Station{" +
                    "address='" + address + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        } else {
            result = "Station{" +
                    "address='" + address + '\'' +
                    ", name='" + name + '\'' +
                    ", paths=" + paths.toString() +
                    '}';
        }
        return result;
    }
}
