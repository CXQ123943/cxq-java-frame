package com.steven.service.impl;

import com.steven.dao.CarDao;
import com.steven.service.CarService;
import lombok.Data;

/**
 * @author CXQ
 * @version 1.0
 */
@Data
public class CarServiceImpl implements CarService {
    private CarDao carDao;

    @Override
    public void info() {
        carDao.info();
    }
}
