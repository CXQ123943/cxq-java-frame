package com.steven.springboot2security.mapper;

import com.steven.springboot2security.pojo.RolePermission;
import com.steven.springboot2security.pojo.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CXQ
 * @version 1.0
 */
@Repository
public interface RolePermissionMapper {

    /**
     * 根据外键查询数据
     *
     * @param roleId 外键
     * @return 一条用户记录
     */
    List<RolePermission> selectById(Integer roleId);

}
