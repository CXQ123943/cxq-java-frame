package com.steven.dao.impl;

import com.steven.dao.CatDao;
import org.springframework.stereotype.Repository;

/**
 * @author CXQ
 * @version 1.0
 */
@Repository
public class CatDaoImpl implements CatDao {

    @Override
    public void info() {
        System.out.println("CatDao.info()...");
    }
}
