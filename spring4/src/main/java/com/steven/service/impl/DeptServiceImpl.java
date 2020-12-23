package com.steven.service.impl;

import com.steven.dao.DeptDao;
import com.steven.service.DeptService;

import javax.annotation.Resource;

/**
 * @author CXQ
 * @version 1.0
 */
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptDao deptDao;

    @Override
    public void info() {
        deptDao.info();
    }
}
