package org.example.utils;




import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;

public class JwtUtil {
    private static final String SING = "XIAOSHUANG";


    public static String CreateToken(Map<String, Object> map) {

        Calendar instance = Calendar.getInstance();
        // 默认7天过期
        instance.add(Calendar.DATE, 7);

        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();

        // payload负载
        builder.withClaim("map",map);
        String token = builder.withExpiresAt(instance.getTime())  //指定令牌过期时间
                .sign(Algorithm.HMAC256(SING));  // sign
        return token;
    }

    /**
     * 验证token  合法性
     */
    public static Map<String, Object> verify(String token) {
        return JWT.require(Algorithm.HMAC256(SING)).build().verify(token).getClaim("map").asMap();
    }
}
