package com.solvd.argwinterlab.navigator.db.model;

public class Taxi extends AbstractTransport {
    private String company;

    public Taxi() {}

    public Taxi(long id) {
        super(id);
    }

    public Taxi(long id, int weight, String model, String name) {
        super(id, model, weight, name);
    }

    public Taxi(long id, int weight, String model, String name, String company) {
        super(id, model, weight, name);
        this.company = company;
    }

    public Taxi(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", company=" + company +
                '}';
    }
}
