package org.geoChivas99s;

import org.geoChivas99s.domain.entity.Cliente;
import org.geoChivas99s.domain.repository.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class Main {

   @Bean
   public CommandLineRunner init(@Autowired Clients clients){
       return args -> {
           Cliente c1 = new Cliente("Lindo Mesmo");
           Cliente c2 = new Cliente("Marco Pitra");

          clients.save(c1);
          clients.save(c2);



           System.out.println("--------+----------------");

           clients.delete(c2);
           clients.findAll().forEach(e-> System.out.println(e.getNome()));
          clients.findByNomeLike("");


       };

   }
    public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
    }
}