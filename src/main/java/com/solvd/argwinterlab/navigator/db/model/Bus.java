package com.solvd.argwinterlab.navigator.db.model;

public class Bus extends AbstractTransport {
    private String line;

    public Bus() {}

    public Bus(long id, String model, int weight, String name, String line) {
        super(id, model, weight, name);
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + super.getId() +
                ", model=" + super.getModel() +
                ", weight=" + super.getWeight() +
                ", line=" + line +
                '}';
    }
}
