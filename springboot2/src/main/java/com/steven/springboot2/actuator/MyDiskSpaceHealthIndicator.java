package com.steven.springboot2.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;

/**
 * @author CXQ
 * @version 1.0
 */
@Component(value = "myDiskSpaceHealthIndicator")
public class MyDiskSpaceHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {

         long totalDiskSpace = 0;
         long freeDiskSpace = 0;

         // List the available filesystem roots.
        File[] files = File.listRoots();
        System.out.println(Arrays.toString(files));

        if (files != null && files.length > 0) {

            // 计算磁盘总量以及磁盘剩余空间
            for (File file: files) {
                totalDiskSpace += file.getTotalSpace();
                freeDiskSpace += file.getUsableSpace();
            }

            return Health.up()
                    .withDetail("total", totalDiskSpace + " byte")
                    .withDetail("free", freeDiskSpace + " byte")
                    .build();
        }
        return Health.down().build();
    }
}
