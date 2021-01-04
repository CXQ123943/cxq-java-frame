package com.steven.crud;

import com.steven.mapper.WorkerMapper;
import com.steven.pojo.Worker;
import com.steven.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * @author CXQ
 * @version 1.0
 */
public class WorkerTest {

    private SqlSessionFactory factory = MyBatisUtil.getFactory("mybatis-crud.xml");

    @Test
    public void insert() {
        SqlSession session = factory.openSession();
        WorkerMapper workerMapper = session.getMapper(WorkerMapper.class);
        try {
            workerMapper.insert(new Worker(null, "赵四", 1, 58, "亚洲舞王"));
            workerMapper.insert(new Worker(null, "赵五", 1, 58, "亚洲舞王"));
            workerMapper.insert(new Worker(null, "王四", 1, 58, "亚洲舞王"));
            workerMapper.insert(new Worker(null, "王五", 1, 58, "亚洲舞王"));
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Test
    public void findOneById() {
        try (SqlSession session = factory.openSession()) {
            WorkerMapper workerMapper = session.getMapper(WorkerMapper.class);
            System.out.println(workerMapper.findOneById(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findLikeName() {
        try (SqlSession session = factory.openSession()) {
            WorkerMapper workerMapper = session.getMapper(WorkerMapper.class);
            System.out.println(workerMapper.findLikeName("四"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateById() {
        SqlSession session = factory.openSession();
        WorkerMapper workerMapper = session.getMapper(WorkerMapper.class);
        try {
            workerMapper.updateById(new Worker(1, "刘能", 1, 58, "村副主任"));
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
        WorkerMapper workerMapper = session.getMapper(WorkerMapper.class);
        try {
            workerMapper.deleteById(1);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}