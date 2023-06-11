package org.geoChivas99s;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.geoChivas99s.domain.entity.Users;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    @Value("${security.jwt.expiration}")
    private String expiration;
    @Value("${security.jwt.assignKey}")
    private String assignKey;

    public  String generateToken(Users users){

        long expValue = Long.valueOf(expiration);
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(expValue);
        Instant instant = expirationTime.atZone(ZoneId.systemDefault()).toInstant();
        Date data = Date.from(instant);

        return Jwts.builder()
                .setSubject(users.getLogin())
                .setExpiration(data)
                .signWith(SignatureAlgorithm.HS512 , assignKey).compact();

    }

    public Claims getClaims(String token) throws ExpiredJwtException {
        return Jwts.parser()
                .setSigningKey(assignKey)
                .parseClaimsJwt(token)
                .getBody();
    }

    private boolean isValidToken(String token){
        try {
Claims claims = getClaims(token);
Date expiration = claims.getExpiration();
LocalDateTime localDateTime = expiration.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
return !LocalDateTime.now().isAfter(localDateTime);
        }catch (Exception e){
            return false;

        }
    }

    public String SignIn(String token) throws ExpiredJwtException{

        return (String)
                getClaims(token).getSubject();
    }
/*
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Main.class);

        JwtService service = context.getBean(JwtService.class);

        Users user = Users.builder().login("fulano").build();
        String token = service.generateToken(user);
        System.out.println("Token"+ token);

        boolean isTokenValid = service.isValidToken(token);
        System.out.println(isTokenValid);
    }
*/
}
