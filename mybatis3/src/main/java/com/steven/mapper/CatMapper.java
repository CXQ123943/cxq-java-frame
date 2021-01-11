package com.steven.mapper;

import com.steven.pojo.Cat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author StevenChen
 * @version 1.0
 */
public interface CatMapper {

    /**
     * 添加一只小猫信息
     *
     * @param cat 小猫实体
     */
    void insert(Cat cat);

    /**
     * 查询一只小猫信息
     *
     * @param cat 实例
     * @return 小猫实体
     */
    Cat findOne(Cat cat);

    /**
     * 修改一只小猫信息
     *
     * @param cat 小猫实体
     */
    void updateById(Cat cat);

    /**
     * 通用主键删除一只小猫信息
     *
     * @param id 主键
     */
    void deleteOneById(@Param("aa") int id);
}
