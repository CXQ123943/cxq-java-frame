package com.steven.dao.impl;

import com.steven.dao.DogDao;
import com.steven.pojo.Dog;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @author CXQ
 * @version 1.0
 */
public class DogDaoImpl extends SqlSessionDaoSupport implements DogDao {

    @Override
    public void insert(Dog dog) {
        getSqlSession().insert("dogSpace.insert", dog);
    }
}
