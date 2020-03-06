package com.solvd.argwinterlab.navigator.database.model;

import java.util.ArrayList;
import java.util.List;

public class Path extends AbstractModel {
    private Station destiny;
    private List<AbstractEntity> entities;

    public Path() {}

    public Path(long id) {
        super(id);
    }

    public Path(long id, Station destiny) {
        super(id);
        this.destiny = destiny;
        this.entities = new ArrayList<>();
    }

    public Station getDestiny() {
        return destiny;
    }

    public void setDestiny(Station destiny) {
        this.destiny = destiny;
    }

    public List<AbstractEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<AbstractEntity> entities) {
        this.entities = entities;
    }

    public Path addEntity(AbstractEntity entity) {
        this.entities.add(entity);
        return this;
    }
}
