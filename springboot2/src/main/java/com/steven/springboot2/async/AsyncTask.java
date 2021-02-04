package com.steven.springboot2.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author CXQ
 * @version 1.0
 */
@Component
@Async
public class AsyncTask {

    public void test01() {
        long start = 0;
        long end = 0;
        try {
            start = System.currentTimeMillis();
            TimeUnit.SECONDS.sleep(1L);
            end = System.currentTimeMillis();
            System.out.println("test01()..." + (end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test02() {
        long start = 0;
        long end = 0;
        try {
            start = System.currentTimeMillis();
            TimeUnit.SECONDS.sleep(2L);
            end = System.currentTimeMillis();
            System.out.println("test02()..." + (end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test03() {
        long start = 0;
        long end = 0;
        try {
            start = System.currentTimeMillis();
            TimeUnit.SECONDS.sleep(3L);
            end = System.currentTimeMillis();
            System.out.println("test03()..." + (end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Future<String> task04() {
        try {
            long start = System.currentTimeMillis();
            TimeUnit.SECONDS.sleep(1L);
            long end = System.currentTimeMillis();
            System.out.println("taskD spend: " + (end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>("task04...");
    }

    public Future<String> task05() {
        try {
            long start = System.currentTimeMillis();
            TimeUnit.SECONDS.sleep(2L);
            long end = System.currentTimeMillis();
            System.out.println("taskE spend: " + (end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>("task05...");
    }

    public Future<String> task06() {
        try {
            long start = System.currentTimeMillis();
            TimeUnit.SECONDS.sleep(3L);
            long end = System.currentTimeMillis();
            System.out.println("taskF spend: " + (end - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<>("task06...");
    }

}
