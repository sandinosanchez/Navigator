package com.solvd.argwinterlab.navigator.db.model;

public class Taxi extends AbstractTransport {
    private String company;

    public Taxi() {}

    public Taxi(long id, long weight, String model, String name, String company) {
        super(id, model, weight, name);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
