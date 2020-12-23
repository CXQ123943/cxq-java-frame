package com.steven.aop.proxy;

/**
 * @author CXQ
 * @version 1.0
 */
public interface UserService {

    /**
     * 模拟添加业务方法
     */
    void insert();

    /**
     * 模拟查询业务方法
     */
    void select();

    /**
     * 模拟修改业务方法
     */
    void update();

    /**
     * 模拟删除业务方法
     */
    void delete();

}
