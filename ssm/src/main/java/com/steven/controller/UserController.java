package com.steven.controller;

import com.github.pagehelper.PageInfo;
import com.steven.pojo.User;
import com.steven.service.UserService;
import com.steven.util.JsonData;
import com.steven.util.NullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CXQ
 * @version 1.0
 */
@Controller
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping("paging")
    public JsonData paging(Integer pageNum, Integer pageSize) {
        PageInfo<User> users = userService.paging(pageNum, pageSize);
        if (NullUtil.isNull(users)) {
            return new JsonData(500, "data empty...");
        } else {
            return new JsonData(users);
        }
    }

    @ResponseBody
    @RequestMapping("find-by-id")
    public JsonData findById(Integer id) {
        return new JsonData(userService.findById(id));
    }

    @ResponseBody
    @RequestMapping("insert")
    public JsonData insert(User user) {
        userService.insert(user);
        return new JsonData(200, "insert success!");
    }

    @ResponseBody
    @RequestMapping("update-by-id")
    public JsonData updateById(User user) {
        userService.updateById(user);
        return new JsonData(200, "update success!");
    }

    @ResponseBody
    @RequestMapping("delete-by-ids")
    public JsonData deleteById(Integer[] ids) {
        userService.deleteByIds(ids);
        return new JsonData(200, "delete success!");
    }

}
