package com.steven.springboot2security.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author CXQ
 * @version 1.0
 */
@SpringBootTest
class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    void selectById() {
        System.out.println(roleMapper.selectById(2));
    }
}
