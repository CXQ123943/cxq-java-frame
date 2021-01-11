package com.steven.dao.impl;

import com.steven.dao.DogDao;
import com.steven.pojo.Dog;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author CXQ
 * @version 1.0
 */
public class DogDaoImpl extends SqlSessionDaoSupport implements DogDao {

    @Override
    public void insert(Dog dog) {
        getSqlSession().insert("dogSpace.insert", dog);
    }

    @Override
    public Dog findOne(Dog dog) {
        return getSqlSession().selectOne("dogSpace.findOne", dog);
    }

    @Override
    public void updateById(Dog dog) {
        getSqlSession().update("dogSpace.updateById", dog);
    }

    @Override
    public void deleteOneById(int id) {
        getSqlSession().delete("dogSpace.deleteOneById", id);
    }
}
