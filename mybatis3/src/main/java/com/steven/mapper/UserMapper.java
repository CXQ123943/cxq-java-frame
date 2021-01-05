package com.steven.mapper;

import com.steven.pojo.User;

import java.util.List;

/**
 * @author StevenChen
 * @version 1.0
 */
public interface UserMapper {

    /**
     * 按照姓名模糊查询以及性别为男的所有符合条件的用户
     *
     * @param user 实体类
     * @return 所有符合条件的用户
     */
    List<User> findLikeNameAndGender(User user);

    /**
     * 根据姓名模糊以及性别精准查询用户信息
     * 若姓名为null，则按性别精准查询
     * 若性别为null，则按姓名模糊查询
     *
     * @param user 用户实体
     * @return 满足条件的用户
     */
    List<User> findLikeNameAndGenderByIf(User user);
}
