package com.steven.springboot2.service;

import com.steven.springboot2.pojo.Student;

/**
 * @author CXQ
 * @version 1.0
 */
public interface StudentService {
    /**
     * 根据主键查询学生记录
     *
     * @param student 学生实体
     * @return 一条学生记录
     */
    Student selectById(Student student);
}
