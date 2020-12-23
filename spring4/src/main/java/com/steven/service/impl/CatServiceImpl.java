package com.steven.service.impl;

import com.steven.dao.CatDao;
import com.steven.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author CXQ
 * @version 1.0
 */
@Service
public class CatServiceImpl implements CatService {
    @Resource
    private CatDao catDao;

    /*@Autowired
    public CatServiceImpl(CatDao catDao) {
        this.catDao = catDao;
    }*/

    @Override
    public void info() {
        catDao.info();
    }
}
