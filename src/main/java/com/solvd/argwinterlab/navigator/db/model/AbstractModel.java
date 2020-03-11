package com.solvd.argwinterlab.navigator.db.model;

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

	@Override
	public String toString() {
		return "AbstractModel [id=" + id + "]";
	}
}
