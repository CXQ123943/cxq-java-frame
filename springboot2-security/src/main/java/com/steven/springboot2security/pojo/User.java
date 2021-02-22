package com.steven.springboot2security.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;

/**
 * @author CXQ
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Integer gender;
    private String info;
}