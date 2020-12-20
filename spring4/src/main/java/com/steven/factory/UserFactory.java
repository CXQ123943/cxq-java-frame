package com.steven.factory;

import com.steven.pojo.User;

/**
 * @author CXQ
 * @version 1.0
 */
public class UserFactory {

    public UserFactory() {
        System.out.println("UserFactory()...");
    }

    public static User getUserByStaticMethod() {
        return new User("static");
    }

    public User getUserByDynamicMethod() {
        return new User("dynamic");
    }
}
