package com.steven.springboot2.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author CXQ
 * @version 1.0
 */
@RequestMapping("api/asyncTask")
@RestController
public class AsyncTaskController {

    private AsyncTask asyncTask;

    @Autowired
    public AsyncTaskController(AsyncTask asyncTask) {
        this.asyncTask = asyncTask;
    }

    @RequestMapping("test")
    public String test() {

        long one = System.currentTimeMillis();
        asyncTask.test01();
        asyncTask.test02();
        asyncTask.test03();
        long two = System.currentTimeMillis();
        System.out.println("test: " + (two - one));
        return "test: " + (two - one);
    }

    @RequestMapping("execute-with-return")
    public String executeWithReturn() {
        long start = System.currentTimeMillis();
        Future<String> task04 = asyncTask.task04();
        Future<String> task05 = asyncTask.task05();
        Future<String> task06 = asyncTask.task06();
        while (true) {
            if (task04.isDone() && task05.isDone() && task06.isDone()) {
                System.out.println("all task is done...");
                break;
            }
        }
        long end = System.currentTimeMillis();
        return "executeWithReturn() spend：" + (end - start);
    }
}