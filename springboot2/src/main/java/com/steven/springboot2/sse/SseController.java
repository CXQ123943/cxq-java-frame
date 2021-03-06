package com.steven.springboot2.sse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CXQ
 * @version 1.0
 */
@RestController
@RequestMapping("api/sse")
public class SseController {

    @RequestMapping(value = "test", produces = "text/event-stream;charset=UTF-8")
    public String test() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:" + Math.random() + "\n\n";
    }
}
