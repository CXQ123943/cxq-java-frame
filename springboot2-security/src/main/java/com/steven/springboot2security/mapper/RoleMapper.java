package com.steven.springboot2security.mapper;

import com.steven.springboot2security.pojo.Role;
import com.steven.springboot2security.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author CXQ
 * @version 1.0
 */
@Repository
public interface RoleMapper {

    /**
     * 根据主键查询数据
     *
     * @param id 用户ID
     * @return 一条用户记录
     */
    Role selectById(Integer id);

}
