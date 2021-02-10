package com.steven.springboot2webflux.controller;

import com.steven.springboot2webflux.pojo.User;
import com.steven.springboot2webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author CXQ
 * @version 1.0
 */
@RestController
@RequestMapping("api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "select-all", produces = "application/stream+json")
    public Flux<User> selectAll() {
        return userService.selectAll().delayElements(Duration.ofSeconds(2));
    }

    @RequestMapping("select-by-id")
    public Mono<User> selectById(Integer id) {
        return userService.selectById(id);
    }

    @RequestMapping("delete-by-id")
    public void deleteById(Integer id) {
        userService.deleteById(id);
    }
}
