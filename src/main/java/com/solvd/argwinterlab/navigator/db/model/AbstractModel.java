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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractModel that = (AbstractModel) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
	public String toString() {
		return "AbstractModel [id=" + id + "]";
	}
}
