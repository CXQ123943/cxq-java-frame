package com.steven.springboot2.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CXQ
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
    private Integer id;
    private String username;
    private String password;
    private String avatar;
}
