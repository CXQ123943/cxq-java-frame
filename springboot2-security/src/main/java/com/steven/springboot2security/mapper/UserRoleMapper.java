package com.steven.springboot2security.mapper;

import com.steven.springboot2security.pojo.User;
import com.steven.springboot2security.pojo.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CXQ
 * @version 1.0
 */
@Repository
public interface UserRoleMapper {

    /**
     * 根据外键查询用户记录
     *
     * @param userId 外键
     * @return 一条用户记录
     */
    List<UserRole> selectById(Integer userId);

}
