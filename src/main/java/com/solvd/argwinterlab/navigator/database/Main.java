package com.solvd.argwinterlab.navigator.database;

import com.solvd.argwinterlab.navigator.database.dao.mysqlimpl.CityDao;

public class Main {

    public static void main(String[] args) {
        System.out.println(new CityDao().findById(1));
    }
}
