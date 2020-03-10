package com.solvd.argwinterlab.navigator.db.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class City extends AbstractModel{
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

    public void addStation(Station station) {
        stations.add(station);
    }

    public void addPath(String origin, String destiny, AbstractTransport transport){
        Optional<Station> originResult = stations.stream()
                .filter(station -> station.getName().equals(origin))
                .findFirst();

        Optional<Station> destinyResult = stations.stream()
                .filter(station -> station.getName().equals(destiny))
                .findFirst();

        if (!originResult.isPresent() || !destinyResult.isPresent())
            return;

        Station originStation = originResult.get();
        Station destinyStation = originResult.get();

        Optional<Path> originPath = originStation.getPaths().stream()
                .filter(path -> path.getDestiny().getName().equals(destiny))
                .findFirst();
        Optional<Path> destinyPath = destinyStation.getPaths().stream()
                .filter(path -> path.getDestiny().getName().equals(origin))
                .findFirst();

        if (originPath.isPresent() && destinyPath.isPresent()){
            originPath.get().addEntity(transport);
            destinyPath.get().addEntity(transport);
        } else {
            originStation.addPath(new Path(destinyStation, transport));
            destinyStation.addPath(new Path(originStation, transport));
        }
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", stations=" + stations.toString() +
                '}';
    }
}
