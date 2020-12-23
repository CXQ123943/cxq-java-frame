package com.steven.aop;

import com.steven.aop.proxy.JdkProxyCompany;
import com.steven.aop.proxy.UserService;
import com.steven.aop.proxy.UserServiceImpl;
import org.junit.Test;

/**
 * @author CXQ
 * @version 1.0
 */
public class JdkProxyTest {

    @Test
    public void jdkProxy() {
        UserService zhaosi = new UserServiceImpl();
        UserService liuneng = (UserService) new JdkProxyCompany().hireProxy(zhaosi);

        liuneng.insert();
        liuneng.select();
        liuneng.update();
        liuneng.delete();
    }
}
