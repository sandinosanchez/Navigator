package com.solvd.argwinterlab.navigator.db.dao;

import com.solvd.argwinterlab.navigator.db.model.Bus;

public interface IBus extends IQuery<Bus, Long> {
    Bus findByName(String name);

    Bus findByModel(String model);

}
