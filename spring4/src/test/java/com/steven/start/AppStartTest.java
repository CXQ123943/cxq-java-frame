package com.steven.start;

import com.steven.pojo.Student;
import com.steven.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author CXQ
 * @version 1.0
 */
public class AppStartTest {

    @Test
    public void start() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/start/app-start.xml");
        Student student = (Student) app.getBean("student");
        Student studentA = (Student) app.getBean("studentA");
        student.setName("zhaosi");
        studentA.setName("steven");
        System.out.println(student.getName());
        System.out.println(studentA.getName());
        app.close();
    }

    @Test
    public void fileSystem() {
        FileSystemXmlApplicationContext fileSystemApp = new FileSystemXmlApplicationContext("app-start-system.xml");
        Student studentB = (Student) fileSystemApp.getBean("studentB");
        studentB.setName("studentB");
        System.out.println(studentB.getName());
        fileSystemApp.close();
    }

    @Test
    public void getBeanById() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/start/app-by-id.xml");
        Student studentById = (Student) app.getBean("studentById");
        studentById.setName("spring/start/app-by-id.xml");
        System.out.println(studentById.getName());
        app.close();
    }

    @Test
    public void getBeanByName() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/start/app-by-name.xml");
        Student studentByName = (Student) app.getBean("admin");
        studentByName.setName("admin");
        System.out.println(studentByName.getName());
        app.close();
    }

    @Test
    public void getBeanByClass() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/start/app-by-class.xml");
        Student student = app.getBean(Student.class);
        student.setName("class");
        System.out.println(student.getName());
        app.close();
    }

    @Test
    public void buildBeanByConstructor() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/start/app-by-constructor.xml");
        app.getBean(User.class);
        app.close();
    }

    @Test
    public void buildBeanByStaticFactory() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/start/app-by-static-factory.xml");
        app.getBean(User.class);
        app.close();
    }

    @Test
    public void buildBeanByDynamicFactory() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring/start/app-by-dynamic-factory.xml");
        app.getBean(User.class);
        app.close();
    }
}
