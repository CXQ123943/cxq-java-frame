package com.steven.dynamic;

import com.steven.mapper.EmpMapper;
import com.steven.pojo.Emp;
import com.steven.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

/**
 * @author CXQ
 * @version 1.0
 */
public class EmpTest {

    private SqlSessionFactory factory = MyBatisUtil.getFactory("mybatis-dynamic-crud.xml");

    @Test
    public void findWithDept() {
        try (SqlSession session = factory.openSession()) {
            EmpMapper empMapper = session.getMapper(EmpMapper.class);
            List<Emp> emps = empMapper.findEmpWithDeptByJoin();
            for (Emp emp : emps) {
                System.out.println(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findWithDeptBySelect() {
        try (SqlSession session = factory.openSession()) {
            EmpMapper empMapper = session.getMapper(EmpMapper.class);
            for (Emp emp : empMapper.findEmpWithDeptBySelect()) {
                System.out.printf("%s 在 %s 部门\n", emp.getEname(), emp.getDept().getDname());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findWithDeptByOne() {
        try (SqlSession session = factory.openSession()) {
            EmpMapper empMapper = session.getMapper(EmpMapper.class);
            for (Emp emp : empMapper.findWithDeptByOne()) {
                System.out.printf("%s 在 %s 部门\n", emp.getEname(), emp.getDept().getDname());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findWithDeptByLazy() {
        try (SqlSession session = factory.openSession()) {
            EmpMapper empMapper = session.getMapper(EmpMapper.class);
            // debug here
            List<Emp> emps = empMapper.findEmpWithDeptBySelect();
            System.out.println(emps.get(0).getEname());
            System.out.println(emps.get(0).getSal());
            System.out.println(emps.get(0).getDept().getDname());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}