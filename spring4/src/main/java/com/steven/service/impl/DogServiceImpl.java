package com.steven.service.impl;

import com.steven.dao.DogDao;
import com.steven.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author CXQ
 * @version 1.0
 */
public class DogServiceImpl implements DogService {
    private DogDao dogDao;

    @Autowired
    public DogServiceImpl(DogDao dogDao) {
        this.dogDao = dogDao;
    }

    @Override
    public void info() {
        dogDao.info();
    }
}
