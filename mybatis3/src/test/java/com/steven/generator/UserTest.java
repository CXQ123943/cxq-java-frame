package com.steven.generator;

import com.steven.generator.mapper.UserMapper;
import com.steven.generator.pojo.User;
import com.steven.generator.pojo.UserExample;
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
@ContextConfiguration("classpath:spring/spring-generator.xml")
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setName("赵四2");
        user.setInfo("亚洲舞王");
        userMapper.insert(user);
        System.out.println(user);
    }

    @Test
    public void insertSelective() {
        User user = new User();
        user.setName("赵四2");
        user.setInfo("亚洲舞王");
        userMapper.insertSelective(user);
        System.out.println(user);
    }

    @Test
    public void updateByPrimaryKey() {
        User liuneng = new User();
        liuneng.setId(8);
        liuneng.setName("刘能2");

        User dajiao = new User();
        dajiao.setId(9);
        dajiao.setName("大脚2");

        userMapper.updateByPrimaryKey(liuneng);
        userMapper.updateByPrimaryKeySelective(dajiao);
    }

    @Test
    public void updateByExample() {
        User liuneng = new User();
        liuneng.setName("刘能1");

        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameEqualTo("赵四1");
        // userMapper.updateByExample(liuneng, userExample);
        userMapper.updateByExampleSelective(liuneng, userExample);
    }

    @Test
    public void deleteByPrimaryKey() {
        userMapper.deleteByPrimaryKey(8);
    }

    /**
     * delete from user where age is null or age not between 1 and 150
     */
    @Test
    public void deleteByExample() {
        UserExample userExample = new UserExample();
        userExample.or().andAgeIsNull();
        userExample.or().andAgeNotBetween(1, 150);
        userMapper.deleteByExample(userExample);
    }

    /**
     * select id, name, gender, age, info from user where id = ?
     */
    @Test
    public void selectByPrimaryKey() {
        userMapper.selectByPrimaryKey(7);
    }

    /**
     * select id, name, gender, age, info from user where name like '赵%' and gender = 1
     * select id, name, gender, age, info from user
     */
    @Test
    public void selectByExample() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andNameLike("赵%").andGenderEqualTo(1);
        System.out.println(userMapper.selectByExample(userExample));
        System.out.println(userMapper.selectByExample(new UserExample()));
    }

    /**
     * select count(*) from user where id >= 2
     */
    @Test
    public void countByExample() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andIdGreaterThanOrEqualTo(2);
        System.out.println(userMapper.countByExample(userExample));
    }

    /**
     * select id, name, gender, age, info from user order by age desc
     */
    @Test
    public void setOrderByClause() {
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("age desc");
        System.out.println(userMapper.selectByExample(userExample));
    }

    /**
     * select distinct id, name, gender, age, info from user
     */
    @Test
    public void setDistinct() {
        UserExample userExample = new UserExample();
        userExample.setDistinct(true);
        System.out.println(userMapper.selectByExample(userExample));
    }
}
