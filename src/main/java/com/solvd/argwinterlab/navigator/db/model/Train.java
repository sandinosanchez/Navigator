package com.solvd.argwinterlab.navigator.db.model;

public class Train extends AbstractTransportEntity {
    private int wagons;

    public Train() {}

    public Train(long id, String model, long weight, int wagons) {
        super(id, model, weight);
        this.wagons = wagons;
    }

    public int getWagons() {
        return wagons;
    }

    public void setWagons(int wagons) {
        this.wagons = wagons;
    }
}
