package com.steven.springboot2.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author CXQ
 * @version 1.0
 */
@Component
public class ScheduleTask {

    @Scheduled(fixedDelay = 3000)
    public void printDate() throws InterruptedException {
        TimeUnit.SECONDS.sleep(200L);
        System.out.println("current date: " + new Date());
    }
}