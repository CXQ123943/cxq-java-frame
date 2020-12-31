package com.steven.start;

import com.steven.util.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author CXQ
 * @version 1.0
 */
public class StudentTest {

    @Test
    public void start() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis-student.xml"));
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            System.out.println(sqlSession.getConnection().isClosed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void myBatisUtil() {
        SqlSessionFactory factory = MyBatisUtil.getFactory("mybatis-student.xml");
        System.out.println(MyBatisUtil.getFactory("mybatis-student.xml").hashCode());
        System.out.println(MyBatisUtil.getFactory("mybatis-student.xml").hashCode());
        try (SqlSession session = factory.openSession()) {
            System.out.println(session.getConnection().isClosed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void myBatisUtilWithEnv() {
        SqlSessionFactory factory = MyBatisUtil.getFactory("mybatis-student.xml", "test");
        try (SqlSession session = factory.openSession()) {
            System.out.println(session.getConnection().isClosed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void myBatisUtilWithProps() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/jdbc/db.properties"));
        SqlSessionFactory factory = MyBatisUtil.getFactory("mybatis-student.xml", props);
        try (SqlSession session = factory.openSession()) {
            System.out.println(session.getConnection().isClosed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void myBatisUtilWithEnvAndProps() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/jdbc/db.properties"));
        SqlSessionFactory factory = MyBatisUtil.getFactory("mybatis-student.xml", "test", props);
        try (SqlSession session = factory.openSession()) {
            System.out.println(session.getConnection().isClosed());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}