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
@ContextConfiguration("classpath:spring/spring-sm-dog.xml")
public class DogTest {

    @Autowired
    private DogDao dogDao;

    @Test
    public void insert() {
        dogDao.insert(new Dog(2, "黑皮", 1, 5, "金毛"));
    }

    @Test
    public void findOne() {
        System.out.println(dogDao.findOne(new Dog(2, null, null, null, null)));
    }

    @Test
    public void updateById() {
        dogDao.updateById(new Dog(1, "二蛋子", null, 6, null));
    }

    @Test
    public void deleteOneById() {
        dogDao.deleteOneById(2);
    }
}
