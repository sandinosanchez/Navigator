package com.solvd.argwinterlab.navigator.algorithm;

import com.solvd.argwinterlab.navigator.db.model.AbstractTransport;
import com.solvd.argwinterlab.navigator.db.model.Station;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private Station origin;
    private AbstractTransport transport;

    public Result(){}

    public Result(Station origin) {
        this.origin = origin;
    }

    public Result(){}

    public Result(Station origin, AbstractTransport transport) {
        this.origin = origin;
        this.transport = transport;
    }

    public Station getOrigin() {
        return origin;
    }

    public void setOrigin(Station origin) {
        this.origin = origin;
    }

    public AbstractTransport getTransport() {
        return transport;
    }

    public void setTransport(AbstractTransport transport) {
        this.transport = transport;
    }

    public static Result initResult(Station origin, AbstractTransport transport) {
        return new Result(origin, transport);
    }

    @Override
    public String toString(){
        return transport!=null ?
                "on " + origin.getName() + " take " + transport.getName()  + "\n":
                "on destiny: " + origin.getName();
    }
}