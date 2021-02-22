package com.steven.springboot2security.mapper;

import com.steven.springboot2security.pojo.Permission;
import com.steven.springboot2security.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author CXQ
 * @version 1.0
 */
@Repository
public interface PermissionMapper {

    /**
     * 根据主键查询用户记录
     *
     * @param id 用户ID
     * @return 一条用户记录
     */
    Permission selectById(Integer id);

}
