package com.steven.sm;

import com.steven.dao.DogDao;
import com.steven.pojo.Dog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author CXQ
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-sm.xml")
public class DogTest {

    @Autowired
    private DogDao dogDao;

    @Test
    public void insert() {
        dogDao.insert(new Dog(1, "旺财", 1, 5, "哈士奇"));
    }
}
