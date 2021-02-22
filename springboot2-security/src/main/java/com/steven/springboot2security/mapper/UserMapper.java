package com.steven.springboot2security.mapper;

import com.steven.springboot2security.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author CXQ
 * @version 1.0
 */
@Repository
public interface UserMapper {

    /**
     * 根据用户username查询用户记录
     *
     * @param username 用户username
     * @return 一条用户记录
     */
    User selectByUsername(String username);

}
