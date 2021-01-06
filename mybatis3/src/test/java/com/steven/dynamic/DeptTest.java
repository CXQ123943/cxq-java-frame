package com.steven.dynamic;

import com.steven.mapper.DeptMapper;
import com.steven.mapper.EmpMapper;
import com.steven.pojo.Dept;
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
public class DeptTest {

    private SqlSessionFactory factory = MyBatisUtil.getFactory("mybatis-dynamic-crud.xml");

    @Test
    public void findWithDept() {
        try (SqlSession session = factory.openSession()) {
            DeptMapper deptMapper = session.getMapper(DeptMapper.class);
            List<Dept> depts = deptMapper.findWithEmpsByJoin();
            for (Dept dept : depts) {
                for (Emp emp : dept.getEmps()) {
                    System.out.print(emp.getEname() + " ");
                }
                System.out.println("在" + dept.getDname() + "部门");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findWithEmpsBySelect() {
        try (SqlSession session = factory.openSession()) {
            DeptMapper deptMapper = session.getMapper(DeptMapper.class);
            for (Dept dept : deptMapper.findWithEmpsBySelect()) {
                for (Emp emp : dept.getEmps()) {
                    System.out.print(emp.getEname() + " ");
                }
                System.out.println("在" + dept.getDname() + "部门");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findWithDeptByMany() {
        try (SqlSession session = factory.openSession()) {
            DeptMapper deptMapper = session.getMapper(DeptMapper.class);
            for (Dept dept : deptMapper.findWithEmpsByMany()) {
                for (Emp emp : dept.getEmps()) {
                    System.out.print(emp.getEname() + " ");
                }
                System.out.println("在" + dept.getDname() + "部门");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findWithEmpsByLazy() {
        try (SqlSession session = factory.openSession()) {
            DeptMapper deptMapper = session.getMapper(DeptMapper.class);
            // debug here
            List<Dept> depts = deptMapper.findWithEmpsBySelect();
            System.out.println(depts.get(0).getDname());
            System.out.println(depts.get(0).getLoc());
            System.out.println(depts.get(0).getEmps().get(0).getEname());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}