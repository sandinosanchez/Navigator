package com.solvd.argwinterlab.navigator.db.dao;

import com.solvd.argwinterlab.navigator.db.model.Train;

public interface TrainMapper extends IQuery<Train, Long> {
    Train findByName(String name);
}
