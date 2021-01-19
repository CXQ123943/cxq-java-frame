package com.steven.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.steven.mapper.UserMapper;
import com.steven.pojo.User;
import com.steven.service.UserService;
import com.steven.util.NullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author CXQ
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public PageInfo<User> paging(Integer pageNum, Integer pageSize) {
        if (NullUtil.isNull(pageNum) || NullUtil.isNull(pageSize)) {
            return new PageInfo<>();
        }
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(userMapper.findAll());
    }

    @Override
    public User findById(Integer id) {
        if (id < 0) {
            return new User();
        }

        User result = userMapper.findById(id);
        if (NullUtil.isNull(result)) {
            return new User();
        }

        return result;
    }

    @Transactional(rollbackForClassName = "Exception")
    @Override
    public int insert(User user) {
        if (NullUtil.isNull(user)) {
            return -1;
        }
        // throw new RuntimeException("回滚...");
        return userMapper.insert(user);
    }

    @Transactional(rollbackForClassName = "Exception")
    @Override
    public int deleteByIds(Integer[] ids) {
        int result = 0;
        if (ids != null && ids.length != 0) {
            for (Integer id: ids) {
                if (id == null) {
                    throw new NullPointerException("ids中有元素为null");
                }
            }
            result = userMapper.deleteByIds(ids);
        }
        return result;
    }

    @Transactional(rollbackForClassName = "Exception")
    @Override
    public int updateById(User user) {
        if (NullUtil.isNull(user)) {
            return -1;
        }

        return userMapper.updateById(user);
    }
}
