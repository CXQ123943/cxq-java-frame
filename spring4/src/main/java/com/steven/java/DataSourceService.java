package com.steven.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author CXQ
 * @version 1.0
 */
@Service
public class DataSourceService {
    private DataSourceDao dataSourceDao;

    @Autowired
    public DataSourceService(DataSourceDao dataSourceDao) {
        this.dataSourceDao = dataSourceDao;
    }

    public boolean getConnection() throws SQLException {
        return dataSourceDao.getConnection();
    }
}
