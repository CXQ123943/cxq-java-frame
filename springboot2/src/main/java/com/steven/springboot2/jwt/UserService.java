package com.steven.springboot2.jwt;

import org.springframework.stereotype.Service;

/**
 * @author CXQ
 * @version 1.0
 */
public interface UserService {

    /**
     * 登录操作
     *
     * @param user 用户实体
     * @return 对应用户的一条记录
     */
    User login(User user);
}
