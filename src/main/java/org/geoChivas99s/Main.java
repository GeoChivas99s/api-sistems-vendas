package org.geoChivas99s;

import org.geoChivas99s.domain.entity.Cliente;
import org.geoChivas99s.domain.entity.Pedido;
import org.geoChivas99s.domain.repository.Clients;
import org.geoChivas99s.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class Main {

@Bean
    public  CommandLineRunner commandLineRunner( @Autowired Clients clients   ){
return args -> {
  clients.save( new Cliente("Geovane Chivas", null));
    clients.save( new Cliente("Marco", null));
};
    }
    public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
    }
}