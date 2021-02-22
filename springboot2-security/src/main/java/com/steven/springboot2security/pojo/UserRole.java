package com.steven.springboot2security.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author CXQ
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRole implements Serializable {
    private Integer id;
    private User userId;
    private Role roleId;
}