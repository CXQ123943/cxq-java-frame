package com.steven.springboot2.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CXQ
 * @version 1.0
 */
@RestController
@RequestMapping("/api/jwt")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("login")
    public String login(User user) {
        User userFromDb = userService.login(user);
        if (userFromDb != null) {
            String secretKey = userFromDb.getPassword();
            return JWT.create()
                    .withClaim("username", userFromDb.getUsername())
                    .withClaim("id", userFromDb.getId())
                    .withClaim("password", secretKey)
                    .withClaim("avatar", userFromDb.getAvatar())
                    .withIssuer("steven").sign(Algorithm.HMAC256(secretKey));
        }
        return "login fail...";
    }

    @LoginAuth
    @RequestMapping("execute")
    public String execute() {
        return "execute()...";
    }
}
