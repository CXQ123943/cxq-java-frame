package com.steven.springboot2security.service;

import com.steven.springboot2security.mapper.RolePermissionMapper;
import com.steven.springboot2security.mapper.UserMapper;
import com.steven.springboot2security.mapper.UserRoleMapper;
import com.steven.springboot2security.pojo.RolePermission;
import com.steven.springboot2security.pojo.User;
import com.steven.springboot2security.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CXQ
 * @version 1.0
 */
@Component
public class UserServiceImpl implements UserDetailsService {

    private UserMapper userMapper;
    private UserRoleMapper userRoleMapper;
    private RolePermissionMapper rolePermissionMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRoleMapper userRoleMapper, RolePermissionMapper rolePermissionMapper) {
        this.userMapper = userMapper;
        this.userRoleMapper = userRoleMapper;
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectByUsername(username);

        if (user == null) {
            throw new RuntimeException("username not exist...");
        }

        List<UserRole> userRoles = userRoleMapper.selectById(user.getId());
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            authorities.add(new SimpleGrantedAuthority(userRole.getRoleId().getTitle()));
            for (RolePermission rolePermission : rolePermissionMapper.selectById(userRole.getRoleId().getId())) {
                authorities.add(new SimpleGrantedAuthority(rolePermission.getPermissionId().getTitle()));
            }
        }

        String password = "{noop}" + user.getPassword();
        return new org.springframework.security.core.userdetails.User(username, password, authorities);
    }
}
