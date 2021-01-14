package com.steven.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author CXQ
 * @version 1.0
 */
@Data
public class User implements Serializable {
    private String name;
    private Integer age;
    private Boolean gender;
}
