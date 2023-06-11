package org.geoChivas99s;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.geoChivas99s.domain.entity.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.core.userdetails.User;
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


    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Main.class);

        JwtService service = context.getBean(JwtService.class);

        Users user = Users.builder().login("fulano").build();
        System.out.println("Token"+ service.generateToken(user));

    }

}
