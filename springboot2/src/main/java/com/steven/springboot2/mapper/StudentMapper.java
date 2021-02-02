package com.steven.springboot2.mapper;

import com.steven.springboot2.pojo.Student;
import org.springframework.stereotype.Repository;

/**
 * @author CXQ
 * @version 1.0
 */
@Repository
public interface StudentMapper {

    /**
     * 根据主键查询学生记录
     *
     * @param id 学生ID
     * @return 一条学生记录
     */
    Student selectById(Integer id);

    /**
     * 新增一名学生
     *
     * @param student 实例
     */
    void insert(Student student);

    /**
     * 修改一名学生
     *
     * @param student 实例
     */
    void updateById(Student student);

    /**
     * 根据学生ID数组查询学生记录
     *
     * @param ids 学生ID数组
     */
    void deleteByIds(Integer[] ids);
}
