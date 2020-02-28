package com.solvd.argwinterlab.navigator.database.model;

public class Path extends AbstractModel {
    private Station origin;
    private Station destiny;
    private Train train;

    public Path() {}

    public Path(long id) {
        super(id);
    }

    public Path(long id, Station origin, Station destiny, Train train) {
        super(id);
        this.origin = origin;
        this.destiny = destiny;
        this.train = train;
    }

    public Station getOrigin() {
        return origin;
    }

    public void setOrigin(Station origin) {
        this.origin = origin;
    }

    public Station getDestiny() {
        return destiny;
    }

    public void setDestiny(Station destiny) {
        this.destiny = destiny;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
