package com.steven.dynamic;

import com.steven.mapper.UserMapper;
import com.steven.pojo.User;
import com.steven.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void findLikeNameAndGenderByWhere() {
        try (SqlSession session = factory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            System.out.println(userMapper.findLikeNameAndGenderByWhere(new User(null, null, null, null, null)));
            System.out.println(userMapper.findLikeNameAndGenderByWhere(new User(null, null, 1, null, null)));
            System.out.println(userMapper.findLikeNameAndGenderByWhere(new User(null, "王", null, null, null)));
            System.out.println(userMapper.findLikeNameAndGenderByWhere(new User(null, "王", 1, null, null)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findLikeNameAndGenderByTrim() {
        try (SqlSession session = factory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            System.out.println(userMapper.findLikeNameAndGenderByTrim(new User(null, null, null, null, null)));
            System.out.println(userMapper.findLikeNameAndGenderByTrim(new User(null, null, 1, null, null)));
            System.out.println(userMapper.findLikeNameAndGenderByTrim(new User(null, "王", null, null, null)));
            System.out.println(userMapper.findLikeNameAndGenderByTrim(new User(null, "王", 1, null, null)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findLikeNameAndGenderByChoose() {
        try (SqlSession session = factory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            System.out.println(userMapper.findLikeNameAndGenderByChoose(new User(1, "王", 1, null, null)));
            System.out.println(userMapper.findLikeNameAndGenderByChoose(new User(1, "王", null, null, null)));
            System.out.println(userMapper.findLikeNameAndGenderByChoose(new User(1, null, 1, null, null)));
            System.out.println(userMapper.findLikeNameAndGenderByChoose(new User(1, null, null, null, null)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findWithArrayByForEach() {
        int[] ids = {3, 4, 6};
        try (SqlSession session = factory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            System.out.println(userMapper.findWithArrayByForEach(ids));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findWithListByForEach() {
        List<Integer> ids = new ArrayList<>();
        ids.add(3);
        ids.add(4);
        ids.add(6);
        try (SqlSession session = factory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            System.out.println(userMapper.findWithListByForEach(ids));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findWithMapByForEach() {
        List<Integer> ids = new ArrayList<>();
        ids.add(3);
        ids.add(4);
        ids.add(6);

        Map<String, Object> map = new HashMap<>(1);
        map.put("ids", ids);
        try (SqlSession session = factory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            System.out.println(userMapper.findWithMapByForEach(map));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateByIdWithSet() {
        SqlSession session = factory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            userMapper.updateByIdWithSet(new User(1, "赵四", null, null, null));
            userMapper.updateByIdWithSet(new User(1, null, null, 100, null));
            userMapper.updateByIdWithSet(new User(2, "33", null, 100, null));
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void updateByIdWithTrim() {
        SqlSession session = factory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            userMapper.updateByIdWithTrim(new User(3, "赵四", null, null, null));
            userMapper.updateByIdWithTrim(new User(3, null, null, 100, null));
            userMapper.updateByIdWithTrim(new User(4, "33", null, 100, null));
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void findByNameAndGender() {
        try (SqlSession session = factory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            System.out.println(userMapper.findByNameAndGender("赵", 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findBySingleParam() {
        try (SqlSession session = factory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            System.out.println(userMapper.findBySingleParam("赵"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByMultipleParam() {
        User user1 = new User(null, "赵", null, 100, null);
        User user2 = new User(null, null, 1, null, null);
        try (SqlSession session = factory.openSession()) {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            System.out.println(userMapper.findByMultiplePojoParam(user1, user2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}