package com.steven.di;

import com.steven.pojo.Emp;
import com.steven.service.CarService;
import com.steven.service.DeptService;
import com.steven.service.impl.CarServiceImpl;
import com.steven.service.impl.CatServiceImpl;
import com.steven.service.impl.DeptServiceImpl;
import com.steven.service.impl.DogServiceImpl;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author CXQ
 * @version 1.0
 */
public class DiTest {
    private ClassPathXmlApplicationContext app;

    @Test
    public void constant() {
        app = new ClassPathXmlApplicationContext("classpath:spring/di/constant.xml");
        Emp emp = app.getBean(Emp.class);
        System.out.println(emp.getName());
        System.out.println(emp.getAge());
        System.out.println(Arrays.toString(emp.getHobby()));
        System.out.println(emp.getUserList());
        System.out.println(emp.getUserSet());
        System.out.println(emp.getUserMap());
        System.out.println(emp.getJdbc());
    }

    @Test
    public void constructor() {
        app = new ClassPathXmlApplicationContext("classpath:spring/di/constructor.xml");
    }

    @Test
    public void beanOuter() {
        app = new ClassPathXmlApplicationContext("classpath:spring/di/bean-outer.xml");
        app.getBean(CarServiceImpl.class).info();
    }

    @Test
    public void beanInner() {
        app = new ClassPathXmlApplicationContext("classpath:spring/di/bean-inner.xml");
        app.getBean(CarServiceImpl.class).info();
    }

    @Test
    public void deptDao() {
        app = new ClassPathXmlApplicationContext("classpath:spring/di/dept.xml");
        app.getBean(DeptServiceImpl.class).info();
    }

    @Test
    public void dogDao() {
        app = new ClassPathXmlApplicationContext("classpath:spring/di/dog.xml");
        app.getBean(DogServiceImpl.class).info();
    }

    @Test
    public void catDao() {
        app = new ClassPathXmlApplicationContext("classpath:spring/di/cat.xml");
        app.getBean(CatServiceImpl.class).info();
    }

    @After
    public void after() {
        app.close();
    }
}
