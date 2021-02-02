package com.steven.springboot2.controller;

import com.steven.springboot2.pojo.Student;
import com.steven.springboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CXQ
 * @version 1.0
 */
@RestController
@RequestMapping("api/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("select-by-id")
    public Student findById(Student student) {
        return studentService.selectById(student);
    }

}
