package com.steven.springboot2webflux.service.impl;

import com.steven.springboot2webflux.pojo.User;
import com.steven.springboot2webflux.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CXQ
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "admin"));
        users.add(new User(2, "steven"));
        users.add(new User(3, "roy"));
        users.add(new User(4, "zds"));
    }

    @Override
    public Flux<User> selectAll() {
        return Flux.fromIterable(users);
    }

    @Override
    public Mono<User> selectById(Integer id) {
        User user = null;
        if (id != null && id > 0) {
            for (User e : users) {
                if (id.equals(e.getId())) {
                    user = e;
                    break;
                }
            }
        }
        return Mono.justOrEmpty(user);
    }

    @Override
    public void deleteById(Integer id) {
        if (id != null && id > 0) {
            for (User e : users) {
                if (id.equals(e.getId())) {
                    users.remove(e);
                    break;
                }
            }
        }
    }
}
