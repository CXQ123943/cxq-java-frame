package com.steven.springboot2webflux.service;

import com.steven.springboot2webflux.pojo.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author CXQ
 * @version 1.0
 */
public interface UserService {

    /**
     * 查询所有数据
     *
     * @return 返回所有数据
     */
    Flux<User> selectAll();

    /**
     * 通过主键查询一条数据
     *
     * @param id 主键
     * @return 返回所有数据
     */
    Mono<User> selectById(Integer id);

    /**
     * 通删除一条数据
     *
     * @param id 主键
     */
    void deleteById(Integer id);
}
