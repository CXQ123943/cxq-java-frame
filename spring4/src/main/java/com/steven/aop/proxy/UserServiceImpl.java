package com.steven.aop.proxy;

/**
 * @author CXQ
 * @version 1.0
 */
public class UserServiceImpl implements UserService {
    @Override
    public void insert() {
        System.out.println("insert()...");
    }

    @Override
    public void select() {
        System.out.println("select()...");
    }

    @Override
    public void update() {
        System.out.println("update()...");
    }

    @Override
    public void delete() {
        System.out.println("delete()...");
    }
}
