package com.steven.crud;

import com.steven.mapper.UserMapper;
import com.steven.pojo.User;
import com.steven.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

/**
 * @author CXQ
 * @version 1.0
 */
public class UserTest {
    private SqlSessionFactory factory = MyBatisUtil.getFactory("mybatis-dynamic-crud.xml");

    @Test
    public void findLikeNameAndGender() {
        SqlSession session = factory.openSession();
        User user = new User();
        user.setName("王");
        user.setGender(1);
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            List<User> result = userMapper.findLikeNameAndGender(user);
            session.commit();
            System.out.println(result);
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void findLikeNameAndGenderByIf() {
        SqlSession session = factory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            System.out.println(userMapper.findLikeNameAndGenderByIf(new User(null, null, 1, null, null)));
            System.out.println(userMapper.findLikeNameAndGenderByIf(new User(null, "王", null, null, null)));
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }



}