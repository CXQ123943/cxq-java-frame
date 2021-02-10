package com.steven.springboot2webflux.controller;

import com.steven.springboot2webflux.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author CXQ
 * @version 1.0
 */
class UserControllerTest {

    @Test
    void webClientMono() {
        // 写法一
        /*Mono<User> userMono = WebClient.create("http://127.0.0.1:8080/api/user/select-by-id?id=2")
                .get().retrieve().bodyToMono(User.class);*/

        // 写法二
        Mono<User> userMono = WebClient.create().get()
                .uri("http://127.0.0.1:8080/api/user/select-by-id?id=2")
                .retrieve().bodyToMono(User.class);

        System.out.println(userMono.block());
    }

    @Test
    void webClientFlux() {
        Flux<User> userFlux = WebClient.create().get()
                .uri("http://127.0.0.1:8080/api/user/select-all")
                .retrieve().bodyToFlux(User.class);

        System.out.println(userFlux.collectList().block());
    }
}
