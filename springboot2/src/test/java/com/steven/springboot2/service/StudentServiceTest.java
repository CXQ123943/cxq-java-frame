package com.steven.springboot2.service;

import com.steven.springboot2.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author CXQ
 * @version 1.0
 */
@SpringBootTest
class StudentServiceTest {
    private StudentService studentService;

    @Autowired
    StudentServiceTest(StudentService studentService) {
        this.studentService = studentService;
    }

    @Test
    void selectById() {
        Student student = new Student();
        student.setId(1);
        System.out.println(studentService.selectById(student));
    }
}
