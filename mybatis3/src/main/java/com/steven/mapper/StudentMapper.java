package com.steven.mapper;

import com.steven.pojo.Student;

import java.util.List;

/**
 * @author StevenChen
 * @version 1.0
 */
public interface StudentMapper {

    /**
     * 添加一条学生信息
     *
     * @param student 学生实体
     */
    void insert(Student student);

    /**
     * 通过主键查询一条学生信息
     *
     * @param id 主键
     * @return 学生实体
     */
    Student findOneById(int id);

    /**
     * 按照姓名模糊查询所有符合条件的学生
     *
     * @param name 姓名的模糊查询部分
     * @return 所有符合条件的学生
     */
    List<Student> findLikeName(String name);

    /**
     * 通用主键修改一条学生信息
     *
     * @param student 学生实体
     */
    void updateById(Student student);

    /**
     * 通用主键删除一条学生信息
     *
     * @param id 主键
     */
    void deleteById(int id);
}
