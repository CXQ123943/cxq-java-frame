package com.steven.springboot2security.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author CXQ
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role implements Serializable {
    private Integer id;
    private String title;
    private String info;
    private Date lastModify;
}