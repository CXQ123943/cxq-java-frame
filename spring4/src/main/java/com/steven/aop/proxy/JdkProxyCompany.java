package com.steven.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author CXQ
 * @version 1.0
 */
public class JdkProxyCompany implements InvocationHandler {
    private Object customer;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("鉴权...");
        Object methodReturn = method.invoke(customer, args);
        System.out.println("日志...");
        return methodReturn;
    }

    /**
     * 只要调用该方法，就能成功的为指定的客户聘请一个JDK代理
     *
     * @param customer 想要聘用代理的客户
     * @return 对应客户的代理
     */
    public Object hireProxy(Object customer) {
        this.customer = customer;
        return Proxy.newProxyInstance(
                customer.getClass().getClassLoader(),
                customer.getClass().getInterfaces(), this);
    }
}
