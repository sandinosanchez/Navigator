package com.solvd.argwinterlab.navigator.db.dao.mysqlimpl;

public abstract class AbstractDao {
    private long id;

    public AbstractDao() {}

    public AbstractDao(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
