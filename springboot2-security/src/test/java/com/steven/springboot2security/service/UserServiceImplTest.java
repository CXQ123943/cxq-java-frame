package com.steven.springboot2security.service;

import com.steven.springboot2security.mapper.RolePermissionMapper;
import com.steven.springboot2security.mapper.UserRoleMapper;
import com.steven.springboot2security.pojo.RolePermission;
import com.steven.springboot2security.pojo.User;
import com.steven.springboot2security.pojo.UserRole;
import javafx.scene.media.VideoTrack;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author CXQ
 * @version 1.0
 */
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

}
