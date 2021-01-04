package com.steven.mapper;

import com.steven.pojo.Worker;

import java.util.List;

/**
 * @author StevenChen
 * @version 1.0
 */
public interface WorkerMapper {

    /**
     * 添加一条工人信息
     *
     * @param worker 工人实体
     */
    void insert(Worker worker);

    /**
     * 通过主键查询一条工人信息
     *
     * @param id 主键
     * @return 工人实体
     */
    Worker findOneById(int id);

    /**
     * 按照姓名模糊查询所有符合条件的工人
     *
     * @param name 姓名的模糊查询部分
     * @return 所有符合条件的工人
     */
    List<Worker> findLikeName(String name);

    /**
     * 通用主键修改一条工人信息
     *
     * @param worker 工人实体
     */
    void updateById(Worker worker);

    /**
     * 通用主键删除一条工人信息
     *
     * @param id 主键
     */
    void deleteById(int id);
}
