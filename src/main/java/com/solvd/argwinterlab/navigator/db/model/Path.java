package com.solvd.argwinterlab.navigator.db.model;

import java.util.ArrayList;
import java.util.List;

public class Path extends AbstractModel {
    private Station destiny;
    private List<AbstractTransportEntity> entities;

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

    public List<AbstractTransportEntity> getEntities() {
        return entities;
    }

    public void setEntities(List<AbstractTransportEntity> entities) {
        this.entities = entities;
    }

    public Path addEntity(AbstractTransportEntity entity) {
        this.entities.add(entity);
        return this;
    }
}
