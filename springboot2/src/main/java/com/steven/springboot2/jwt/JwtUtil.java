package com.steven.springboot2.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author CXQ
 * @version 1.0
 */
public class JwtUtil {

    /**
     * 密钥：不能暴露
     */
    private static String secretKey = "ST6DKF-Y4DG6L-ISK3EH-Y2HDJ2-C4D5OA-C5IW3C-CU5WMC-H3IDK3";

    public static String geneToken(User user) {
        Integer id;
        String username, avatar;
        if (user == null || (id = user.getId()) == null || (username = user.getUsername()) == null || (avatar = user.getAvatar()) == null) {
            return null;
        }

        // 设置负载（发行人，发行时间，过期时间）和签名
        // 每个claim对象都对应payload中的一个kv对
        return Jwts.builder()
                .claim("id", id)
                .claim("username", username)
                .claim("avatar", avatar)
                .setSubject("Steven")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 3600 * 24L))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public static Claims checkToken(String token) {
        final Claims claims;
        try {
            // 获取payload
            claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return claims;
    }

}
