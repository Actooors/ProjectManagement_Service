package com.management.tools;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.management.model.ov.resultsetting.ConstCorrespond;
import com.management.security.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.DefaultClock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;


/**
 * @program: management
 * @description: token工具
 * @author: ggmr
 * @create: 2018-07-29 18:33
 */
@Component
public class JwtUtil {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private static final byte[] ENCODE_KEY = "management".getBytes();
    private static final String TOKEN_PREFIX = "Bearer ";        // Token前缀
    private Clock clock = DefaultClock.INSTANCE;
    private static JWTVerifier jwtVerifier;

    public String createJwt(String subject, Integer identity) {
        Date currentDate = new Date();
        // 过期时间5天
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 36500);
        Algorithm algorithm = Algorithm.HMAC512(ENCODE_KEY);


        String token = JWT.create()
                .withIssuedAt(currentDate)
                .withExpiresAt(calendar.getTime())
                .withSubject(subject)
                .withClaim("identity", ConstCorrespond.USER_AUTHORIZATION[identity])
                .sign(algorithm);

        return TOKEN_PREFIX + token;
    }

    public static String parseJwt(String jwt) throws JWTVerificationException {
        Algorithm algorithm = Algorithm.HMAC512(ENCODE_KEY);
        if (jwtVerifier == null) {
            jwtVerifier = JWT.require(algorithm).build();
        }
        jwtVerifier.verify(jwt);
        return JWT.decode(jwt).getSubject();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {

        JwtUser user = (JwtUser) userDetails;
        final String userId = getUserIdFromToken(token);
        return (
                userId.equals(user.getUsername())
                        // 判断token是否过期
                        && !isTokenExpired(token)
        );
    }

    // 判断token是否失效
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(clock.now());
    }

    private Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public String getUserIdFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(ENCODE_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
