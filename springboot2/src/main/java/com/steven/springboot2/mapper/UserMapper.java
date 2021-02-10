package com.steven.springboot2.mapper;

import com.steven.springboot2.jwt.User;
import com.steven.springboot2.pojo.Student;
import org.springframework.stereotype.Repository;

/**
 * @author CXQ
 * @version 1.0
 */
@Repository
public interface UserMapper {

    /**
     * 根据主键查询用户记录
     *
     * @param id 用户ID
     * @return 一条用户记录
     */
    User selectById(Integer id);

    /**
     * 新增一名用户
     *
     * @param user 实例
     */
    void insert(User user);

    /**
     * 修改一名用户
     *
     * @param user 实例
     */
    void updateById(User user);

    /**
     * 根据用户ID数组查询用户记录
     *
     * @param ids 用户ID数组
     */
    void deleteByIds(Integer[] ids);
}
