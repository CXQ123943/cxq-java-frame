package com.steven.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author CXQ
 * @version 1.0
 */
@Repository
public class DataSourceDao {

    private DataSource dataSource;

    @Autowired
    public DataSourceDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public boolean getConnection() throws SQLException {
        return !dataSource.getConnection().isClosed();
    }
}