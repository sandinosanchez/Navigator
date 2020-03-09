package com.solvd.argwinterlab.navigator.db.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Path extends AbstractModel {
    private Station destiny;
    private List<AbstractTransport> transports;

    public Path() {}

    public Path(long id) {
        super(id);
    }

    public Path(long id, Station destiny) {
        super(id);
        this.destiny = destiny;
        this.transports = new ArrayList<>();
    }

    public Station getDestiny() {
        return destiny;
    }

    public void setDestiny(Station destiny) {
        this.destiny = destiny;
    }

    public List<AbstractTransport> getTransports() {
        return transports;
    }

    public AbstractTransport getTransport() {
        if (Objects.nonNull(transports.get(0)))
            return transports.get(0);
        else
            return null;
    }

    public void setTransports(List<AbstractTransport> transports) {
        this.transports = transports;
    }

    public Path addEntity(AbstractTransport entity) {
        this.transports.add(entity);
        return this;
    }
}
