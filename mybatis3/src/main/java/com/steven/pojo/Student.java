package com.steven.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author CXQ
 * @version 1.0
 */
@Data
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Integer gender;
    private Integer age;
    private String info;
}
