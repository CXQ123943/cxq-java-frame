package com.steven.springboot2.mapper;

import com.steven.springboot2.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author CXQ
 * @version 1.0
 */
@SpringBootTest
class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void findById() {
        System.out.println(studentMapper.selectById(3));
    }

    @Test
    void insert() {
        Student student = new Student();
        student.setAge(99);
        student.setGender(0);
        student.setName("长得帅");
        student.setInfo("测试");
        studentMapper.insert(student);
        System.out.println(student);
    }

    @Test
    void updateById() {
        Student student = new Student();
        student.setId(7);
        student.setAge(12);
        student.setGender(1);
        student.setName("zds");
        student.setInfo("测试");
        studentMapper.updateById(student);
    }

    @Test
    void deleteByIds() {
        Integer[] ids = {7, 3};
        studentMapper.deleteByIds(ids);
    }
}
