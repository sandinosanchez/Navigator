package com.solvd.argwinterlab.navigator.db.model;

public class Bus extends AbstractTransport {
    private String name;

    public Bus() {}

    public Bus(long id, String model, long weight, String name) {
        super(id, model, weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
