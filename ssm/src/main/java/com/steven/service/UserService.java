package com.steven.service;

import com.steven.pojo.User;
import com.steven.util.PagingUtil;

import java.util.List;

/**
 * @author StevenChen
 * @version 1.0
 */
public interface UserService {

    /**
     * 分页查询
     *
     * @param pagingutil 分页实体
     * @return 返回分页查询结果集合
     */
    List<User> paging(PagingUtil pagingutil);

    /**
     * 通过主键查询一条数据
     *
     * @param id 主键  用户ID
     * @return 一条数据
     */
    User findById(Integer id);

    /**
     * 添加一条数据
     *
     * @param user 用户实例
     * @return  返回影响条目数
     */
    int insert(User user);

    /**
     * 通过主键数组删除一条数据
     *
     * @param ids 主键数组
     * @return  返回影响条目数
     */
    int deleteByIds(Integer[] ids);

    /**
     * 通过主键修改一条数据
     *
     * @param user 用户实例
     * @return  返回影响条目数
     */
    int updateById(User user);

}
