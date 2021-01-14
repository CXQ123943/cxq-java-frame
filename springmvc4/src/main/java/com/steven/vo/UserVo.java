package com.steven.vo;

import com.steven.pojo.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author CXQ
 * @version 1.0
 */
@Data
public class UserVo implements Serializable {

    private User user;
    private Integer[] ids;
    private List<User> users;
}
