package com.management.tools;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.Calendar;
import java.util.Date;

/**
 * @program: management
 * @description: token工具
 * @author: ggmr
 * @create: 2018-07-29 18:33
 */
public class JwtUtil {
    private final static byte[] ENCODE_KEY = "management".getBytes();
    private static JWTVerifier jwtVerifier;

    public static String createJwt(String subject, Integer identity) {
        Date currentDate = new Date();
        // 过期时间5天
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 36500);
        Algorithm algorithm = Algorithm.HMAC512(ENCODE_KEY);
        return JWT.create()
                .withIssuedAt(currentDate)
                .withExpiresAt(calendar.getTime())
                .withSubject(subject)
                .withClaim("identity", identity)
                .sign(algorithm);
    }

    public static String parseJwt(String jwt) throws JWTVerificationException {
        Algorithm algorithm  = Algorithm.HMAC512(ENCODE_KEY);
        if (jwtVerifier == null){
            jwtVerifier = JWT.require(algorithm).build();
        }
        jwtVerifier.verify(jwt);
        return JWT.decode(jwt).getSubject();
    }

    public static Integer parseJwtForIdentity(String jwt) {
        Algorithm algorithm  = Algorithm.HMAC512(ENCODE_KEY);
        if (jwtVerifier == null){
            jwtVerifier = JWT.require(algorithm).build();
        }
        jwtVerifier.verify(jwt);
        return JWT.decode(jwt).getClaim("identity").asInt();
    }
}
