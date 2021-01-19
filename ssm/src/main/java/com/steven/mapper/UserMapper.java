package com.steven.mapper;

import com.steven.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author StevenChen
 * @version 1.0
 */
public interface UserMapper {

    /**
     * 通过主键查询一条数据
     *
     * @param id 主键  用户ID
     * @return 一条数据
     */
    User findById(int id);

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

    /**
     * 分页查询
     *
     * @param suffix 分页后缀
     * @return 返回分页查询结果集合
     */
    List<User> paging(@Param("suffix") String suffix);

    /**
     * 查询一共需要多少条数据
     *
     * @return 返回数据总和
     */
    int count();
}
