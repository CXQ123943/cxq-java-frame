package com.steven.dao;

import com.steven.pojo.Dog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 查询一条数据
     *
     * @param dog 一条狗实例
     * @return 返回一条狗实例
     * */
    Dog findOne(Dog dog);

    /**
     * 修改一条数据
     *
     * @param dog 一条狗实例
     * */
    void updateById(Dog dog);

    /**
     * 修改一条数据
     *
     * @param id 一条狗实例
     * */
    void deleteOneById(int id);
}
