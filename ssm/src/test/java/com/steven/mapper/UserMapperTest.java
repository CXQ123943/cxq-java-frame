package com.steven.mapper;

import com.steven.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author CXQ
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/app-*.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findById() {
        System.out.println(userMapper.findById(21));
    }

    @Test
    public void insert() {
        User user = new User();
        user.setId(22);
        user.setName("长得帅");
        user.setAge(18);
        user.setGender(1);
        System.out.println(userMapper.insert(user));
        System.out.println(user);
    }

    @Test
    public void deleteById() {
        Integer[] ids = {21, 22};
        System.out.println(userMapper.deleteByIds(ids));
    }

    @Test
    public void updateById() {
        User user = new User();
        user.setId(21);
        user.setName("陈晓强");
        user.setAge(21);
        user.setGender(1);
        System.out.println(userMapper.updateById(user));
        System.out.println(user);
    }

    @Test
    public void paging() {
        for (User e: userMapper.paging("limit 0, 3")) {
            System.out.println(e);
        }
    }

    @Test
    public void count() {
        System.out.println(userMapper.count());
    }

}
