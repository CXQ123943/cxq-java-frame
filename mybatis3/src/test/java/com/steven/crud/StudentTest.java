package com.steven.crud;

import com.steven.mapper.StudentMapper;
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
    private SqlSessionFactory factory = MyBatisUtil.getFactory("mybatis-crud.xml");

    @Test
    public void insert() {
        Student zhaosi = new Student(null, "赵四", 1, 58, "亚洲舞王");
        Student liuneng = new Student(null, "刘能", 0, 19, "玉田花圃");
        SqlSession session = factory.openSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        try {
            studentMapper.insert(zhaosi);
            studentMapper.insert(liuneng);
            session.commit();
            System.out.println(zhaosi);
            System.out.println(liuneng);
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    @Test
    public void insertWithSelectKey() {
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
        try (SqlSession session = factory.openSession()) {
            System.out.println(session.selectList("studentSpace.findLikeName", "大"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateBuId() {
        Student dajiao = new Student(10, "谢广坤", 2, 60, "广坤山货");
        SqlSession session = factory.openSession();
        try {
            session.selectOne("studentSpace.updateById", dajiao);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void deleteById() {
        SqlSession session = factory.openSession();
        try {
            session.delete("studentSpace.deleteById", 11);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void findAll() {
        SqlSession session = factory.openSession();
        try {
            System.out.print(session.selectList("studentSpace.findAll"));
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}