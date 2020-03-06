package com.solvd.argwinterlab.navigator.database.dao;

import com.solvd.argwinterlab.navigator.database.model.Bus;

public interface IBus extends IQuery<Bus, Long> {
    Bus findByName(String name);

    Bus findByModel(String model);

}
