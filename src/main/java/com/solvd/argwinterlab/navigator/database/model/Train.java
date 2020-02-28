package com.solvd.argwinterlab.navigator.database.model;

public class Train extends AbstractModel {
    private String name;
    private String number;

    public Train() {}

    public Train(long id, String name, String number) {
        super(id);
        this.name = name;
        this.number = number;
    }

    public Train(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
