package com.steven.dao;

import com.steven.pojo.Dog;

/**
 * @author StevenChen
 * @version 1.0
 */
public interface DogDao {

    /**
     * 添加一条数据
     *
     * @param dog 一条狗实例
     * */
    void insert(Dog dog);
}
