package com.solvd.argwinterlab.navigator.db.model;

public abstract class AbstractTransport extends AbstractModel{
    private String model;
    private long weight;

    public AbstractTransport() {}

    public AbstractTransport(long id, String model, long weight) {
        super(id);
        this.model = model;
        this.weight = weight;
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
}
