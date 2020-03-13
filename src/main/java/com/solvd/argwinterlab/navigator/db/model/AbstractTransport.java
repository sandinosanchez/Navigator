package com.solvd.argwinterlab.navigator.db.model;

public abstract class AbstractTransport extends AbstractModel{
    private String model;
    private int weight;
    private String name;

    public AbstractTransport() {}

    public AbstractTransport(long id) {
        super(id);
    }

    public AbstractTransport(long id, String model, int weight, String name) {
        super(id);
        this.model = model;
        this.weight = weight;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{" +
                "model='" + model + '\'' +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                '}';
    }
}
