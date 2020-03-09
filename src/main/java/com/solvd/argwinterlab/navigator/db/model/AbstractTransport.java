package com.solvd.argwinterlab.navigator.db.model;

public abstract class AbstractTransport extends AbstractModel{
    private String model;
    private long weight;
    private String name;

    public AbstractTransport() {}

    public AbstractTransport(long id, String model, long weight, String name) {
        super(id);
        this.model = model;
        this.weight = weight;
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public String getLine() {
        return name;
    }

    public void setLine(String line) {
        this.name = line;
    }
}
