package com.steven.sm;

import com.steven.mapper.CatMapper;
import com.steven.pojo.Cat;
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
@ContextConfiguration("classpath:spring/spring-sm-cat.xml")
public class CatTest {

    @Autowired
    private CatMapper catMapper;

    @Test
    public void insert() {
        catMapper.insert(new Cat(2, "汤姆", 2, 15, "英短"));
    }

    @Test
    public void findOne() {
        System.out.println(catMapper.findOne(new Cat(1, null, null, null, null)));
    }

    @Test
    public void updateById() {
        catMapper.updateById(new Cat(1, "二蛋子", 0, 2, "缅因"));
    }

    @Test
    public void deleteOneById() {
        catMapper.deleteOneById(2);
    }
}
