package com.steven.crud;

import com.steven.pojo.Student;
import com.steven.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * @author CXQ
 * @version 1.0
 */
public class StudentTest {

    @Test
    public void insert() {
        SqlSessionFactory factory = MyBatisUtil.getFactory("mybatis-crud.xml");
        Student zhaosi = new Student(null, "赵四", 1, 58, "亚洲舞王");
        Student liunneng = new Student(5, "刘能", 0, 19, "玉田花圃");
        SqlSession session = factory.openSession();
        try {
            session.insert("studentSpace.insert", zhaosi);
            session.insert("studentSpace.insert", liunneng);
            session.commit();
            System.out.println(zhaosi);
            System.out.println(liunneng);
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Test
    public void insertWithSelectKey() {
        SqlSessionFactory factory = MyBatisUtil.getFactory("mybatis-crud.xml");
        Student dajiao = new Student(null, "大脚", 2, 18, "大脚超市");
        SqlSession session = factory.openSession();
        try {
            session.insert("studentSpace.insertWithSelectKey", dajiao);
            session.commit();
            System.out.println(dajiao);
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void findOneById() {
        SqlSessionFactory factory = MyBatisUtil.getFactory("mybatis-crud.xml");
        Student dajiao = new Student();
        dajiao.setId(10);
        SqlSession session = factory.openSession();
        try {
            Student resultA = session.selectOne("studentSpace.findOneById", 10);
            Student resultB = session.selectOne("studentSpace.findOneById", dajiao);
            session.commit();
            System.out.println(resultA);
            System.out.println(resultB);
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void selectList() {
        SqlSessionFactory factory = MyBatisUtil.getFactory("mybatis-crud.xml");
        try (SqlSession session = factory.openSession()) {
            System.out.println(session.selectList("studentSpace.findLikeName", "大"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}