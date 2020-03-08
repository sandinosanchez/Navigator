package com.solvd.argwinterlab.navigator.db.model;

public abstract class AbstractTransportEntity extends AbstractModel{
    private String model;
    private long weight;

    public AbstractTransportEntity() {}

    public AbstractTransportEntity(long id, String model, long weight) {
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
