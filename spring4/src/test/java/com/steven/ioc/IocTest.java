package com.steven.ioc;

import com.steven.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author CXQ
 * @version 1.0
 */
public class IocTest {
    @Test
    public void buildBeanByConstructor() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/ioc/app-by-constructor.xml");
        app.getBean(User.class);
        app.close();
    }

    @Test
    public void buildBeanByStaticFactory() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/ioc/app-by-static-factory.xml");
        app.getBean(User.class);
        app.close();
    }

    @Test
    public void buildBeanByDynamicFactory() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/ioc/app-by-dynamic-factory.xml");
        app.getBean(User.class);
        app.close();
    }

    @Test
    public void lazy() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath:spring/ioc/lazy.xml");
        app.getBean(User.class);
        app.close();
    }
}
