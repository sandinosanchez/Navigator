package com.solvd.argwinterlab.navigator.database.model;

public class Train extends AbstractEntity {
    private String name;

    public Train() {}

    public Train(long id, String model, long weight, String name) {
        super(id, model, weight);
        this.name = name;
    }

    public Train(String name, String number) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
