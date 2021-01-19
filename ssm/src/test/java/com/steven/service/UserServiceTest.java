package com.steven.service;

import com.steven.pojo.User;
import com.steven.util.PagingUtil;
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
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void paging() {
        for (User e: userService.paging(new PagingUtil()))
        System.out.println(e);
    }

    @Test
    public void findById() {
        System.out.println(userService.findById(5));
    }

    @Test
    public void insert() {
        User user1 = new User();
        user1.setId(21);
        user1.setName("陈晓强");
        user1.setAge(21);
        user1.setGender(1);

        User user2 = new User();
        user2.setId(22);
        user2.setName("长得帅");
        user2.setAge(18);
        user2.setGender(1);

        System.out.println(userService.insert(user1));
        System.out.println(userService.insert(user2));
    }

    @Test
    public void updateById() {
        User user = new User();
        user.setId(21);
        user.setName("陈晓强");
        user.setAge(21);
        user.setGender(1);
        System.out.println(userService.updateById(user));
    }

    @Test
    public void deleteByIds() {
        Integer[] ids = {21, 22};
        System.out.println(userService.deleteByIds(ids));
    }

    @Test
    public void bachUpdateById() {
        User user = new User();
        user.setId(21);
        user.setName("陈晓强");
        user.setAge(99);
        user.setGender(1);

        User user1 = new User();
        System.out.println(userService.updateById(user));
        System.out.println(userService.updateById(user1));
    }
}