package com.steven.springboot2.jwt;

import com.steven.springboot2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public User login(User user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            return null;
        }

        User selectById = userMapper.selectById(user.getId());

        if (selectById == null || selectById.getUsername() == null) {
            return null;
        }

        if (user.getUsername().equals(selectById.getUsername()) && user.getPassword().equals(selectById.getPassword())) {
            return selectById;
        } else {
            return null;
        }
    }
}
