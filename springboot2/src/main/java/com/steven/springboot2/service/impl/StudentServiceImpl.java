package com.steven.springboot2.service.impl;

import com.steven.springboot2.mapper.StudentMapper;
import com.steven.springboot2.pojo.Student;
import com.steven.springboot2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author JoeZhou
 */
@Service
public class StudentServiceImpl implements StudentService {

    private StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public Student selectById(Student student) {
        Integer id;
        if (student == null || (id = student.getId()) == null) {
            return new Student();
        }
        return studentMapper.selectById(student.getId());
    }
}
