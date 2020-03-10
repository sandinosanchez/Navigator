package com.solvd.argwinterlab.navigator.db.model;

public class Train extends AbstractTransport {
    private int wagons;

    public Train() {}

    public Train(long id, String model, int weight, String name, int wagons) {
        super(id, model, weight, name);
        this.wagons = wagons;
    }

    public int getWagons() {
        return wagons;
    }

    public void setWagons(int wagons) {
        this.wagons = wagons;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + super.getId() +
                ", model=" + super.getModel() +
                ", weight=" + super.getWeight() +
                ", wagons=" + wagons +
                '}';
    }
}
