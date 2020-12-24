package com.steven.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author CXQ
 * @version 1.0
 */
@Aspect
@Component
public class CustomerAspectByAnnotation {

    @Pointcut("execution(public * com.steven.aop.aspect..*.delete(..))")
    public void deletePointCut() {}

    @Pointcut("execution(public * com.steven.aop.aspect..*.select(..))")
    public void selectPointCut() {}

    @Pointcut("execution(public * com.steven.aop.aspect..*.update(..))")
    public void updatePointCut() {}

    @Pointcut("execution(public * com.steven.aop.aspect..*.insert(..))")
    public void insertPointCut() {
    }

    @Before(value = "deletePointCut()&&args(name, id)", argNames = "name,id")
    public void beforeAdvice(String name, Integer id) {
        System.out.println("beforeAdvice(): 鉴权...");
        System.out.println("param: " + name + " is " + id);
    }

    @After("deletePointCut()")
    public void afterAdvice() {
        System.out.println("afterAdvice(): 记录日志...");
    }

    @AfterReturning(value = "selectPointCut()&&args(name)", returning = "list", argNames = "name,list")
    public void afterReturning(String name, List<String> list) {
        System.out.println("afterReturningAdvice(): 改变原返回值...");
        System.out.println("\tparams: " + name);
        System.out.println("\tpre return value: " + list);
        list.remove("zhaosi");
        list.add("liuneng");
    }

    @AfterThrowing(value = "updatePointCut()&&args(user)", throwing = "e")
    public void afterThrowingAdvice(Map<String, Object> user, Exception e) {
        System.out.println("afterThrowingAdvice(): 爆发异常...");
        System.out.println("\tparams: " + user);
        System.out.println("\texception: " + e);
    }

    @SuppressWarnings("unchecked")
    @Around("insertPointCut()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        List<Integer> list = null;
        System.out.println("aroundAdvice(): 环绕开始...");
        Object[] args = pjp.getArgs();
        System.out.println("\tparams: " + Arrays.toString(args));
        try {
            System.out.println("aroundAdvice(): 鉴权...");
            list = (List<Integer>) pjp.proceed(args);
        } catch (Throwable e) {
            System.out.println("aroundAdvice(): 爆发异常...");
            System.out.println("\texception: " + e);
        } finally {
            System.out.println("aroundAdvice(): 打印日志...");
            System.out.println("aroundAdvice(): 将原返回值 [1,2,3] 改为 [4,5,6]...");
            if (list != null) {
                list.clear();
                list.add(4);
                list.add(5);
                list.add(6);
            }
        }
        return list;
    }
}
