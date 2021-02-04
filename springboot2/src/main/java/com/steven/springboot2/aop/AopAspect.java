package com.steven.springboot2.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

/**
 * @author CXQ
 * @version 1.0
 */
@Aspect
@Configuration
public class AopAspect {

    @Around("execution(* com.steven.springboot2.aop..*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("AOP: around.before");
        Object result = null;
        try {
            // 放行
            System.out.println("AOP: 鉴权");
            result = pjp.proceed(pjp.getArgs());
            System.out.println("AOP: around.returning");
        } catch (Throwable e) {
            System.out.println("AOP: around.throwing an exception");
            /*return e;*/
        }

        System.out.println("AOP: around.after");
        return result;
    }
}