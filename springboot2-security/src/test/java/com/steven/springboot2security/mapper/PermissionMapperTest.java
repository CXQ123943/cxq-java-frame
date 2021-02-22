package com.steven.springboot2security.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author CXQ
 * @version 1.0
 */
@SpringBootTest
class PermissionMapperTest {

    @Autowired
    private PermissionMapper permissionMapper;

    @Test
    void selectById() {
        System.out.println(permissionMapper.selectById(1));
    }
}
