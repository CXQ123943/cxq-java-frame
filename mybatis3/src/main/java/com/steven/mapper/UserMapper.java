package com.steven.mapper;

import com.steven.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author StevenChen
 * @version 1.0
 */
public interface UserMapper {

    /**
     * 按照姓名模糊查询以及性别为男的所有符合条件的用户
     *
     * @param user 实体类
     * @return 所有符合条件的用户
     */
    List<User> findLikeNameAndGender(User user);

    /**
     * 根据姓名模糊以及性别精准查询用户信息
     * 若姓名为null，则按性别精准查询
     * 若性别为null，则按姓名模糊查询
     *
     * @param user 用户实体
     * @return 满足条件的用户
     */
    List<User> findLikeNameAndGenderByIf(User user);

    /**
     * 根据姓名模糊以及性别精准查询用户信息
     * 若姓名为null，则按性别精准查询
     * 若性别为null，则按姓名模糊查询
     * 若姓名和性别均不为null，则按姓名模糊且按性别精准查询
     * 若姓名和性别均为null，全查
     *
     * @param user 用户实体
     * @return 满足条件的用户
     */
    List<User> findLikeNameAndGenderByWhere(User user);

    /**
     * 根据姓名模糊以及性别精准查询用户信息
     * 若姓名为null，则按性别精准查询
     * 若性别为null，则按姓名模糊查询
     * 若姓名和性别均不为null，则按姓名模糊且按性别精准查询
     * 若姓名和性别均为null，全查
     *
     * @param user 用户实体
     * @return 满足条件的用户
     */
    List<User> findLikeNameAndGenderByTrim(User user);

    /**
     * 根据姓名模糊以及性别精准查询用户信息
     * id不为null时
     * 若姓名不为null，按姓名模糊查询
     * 若姓名为null，但性别不为null，则按性别精准查询
     * 若姓名和性别都为null，则按照id精准查询
     *
     * @param user 用户实体
     * @return 满足条件的用户
     */
    List<User> findLikeNameAndGenderByChoose(User user);

    /**
     * 找到编号为3和4和6的用户
     *
     * @param ids 编号数组
     * @return 满足条件的用户
     */
    List<User> findWithArrayByForEach(int[] ids);

    /**
     * 找到编号为3和4和6的用户
     *
     * @param ids 编号列表
     * @return 满足条件的用户
     */
    List<User> findWithListByForEach(List<Integer> ids);

    /**
     * 找到编号为3和4和6的用户
     *
     * @param userMap 用户信息集合
     * @return 满足条件的用户
     */
    List<User> findWithMapByForEach(Map<String, Object> userMap);

    /**
     * 修改用户信息
     *
     * @param user 用户信息集合
     */
    void updateByIdWithSet(User user);

    /**
     * 修改用户信息
     *
     * @param user 用户信息集合
     */
    void updateByIdWithTrim(User user);

    /**
     * 根据姓名模糊以及性别精准查询用户信息
     *
     * @param name   用户姓名
     * @param gender 用户性别
     * @return 满足条件的用户
     */
    List<User> findByNameAndGender(@Param("aa") String name, @Param("bb") int gender);

    /**
     * 根据姓名模糊查询用户信息
     *
     * @param name 姓名
     * @return 符合条件的用户信息
     */
    List<User> findBySingleParam(@Param("aa") String name);

    /**
     * 根据姓名模糊和性别精准查询用户信息
     *
     * @param name   姓名
     * @param gender 性别
     * @return 符合条件的学生信息
     */
    List<User> findByMultipleParam(@Param("aa") String name, @Param("bb") int gender);

    /**
     * 根据姓名模糊和性别精准查询用户信息
     *
     * @param userA 用户实体
     * @param userB 用户实体
     * @return 符合条件的学生信息
     */
    List<User> findByMultiplePojoParam(@Param("aa") User userA, @Param("bb") User userB);
}
