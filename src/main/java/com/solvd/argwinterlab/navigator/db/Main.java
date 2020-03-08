package com.solvd.argwinterlab.navigator.db;

import com.solvd.argwinterlab.navigator.db.dao.mysqlimpl.CityDao;

public class Main {

    public static void main(String[] args) {
        System.out.println(new CityDao().findById(1L));
    }
}
