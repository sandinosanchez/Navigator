package com.solvd.argwinterlab.navigator.database.model;

public abstract class AbstractModel {
    private long id;

    public AbstractModel() {}

    public AbstractModel(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
