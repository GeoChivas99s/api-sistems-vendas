package org.geoChivas99s;

import org.geoChivas99s.domain.entity.Cargo;
import org.geoChivas99s.domain.entity.Cliente;
import org.geoChivas99s.domain.entity.Pedido;
import org.geoChivas99s.domain.entity.Produto;
import org.geoChivas99s.domain.repository.CargoRepository;
import org.geoChivas99s.domain.repository.Clients;
import org.geoChivas99s.domain.repository.Pedidos;
import org.geoChivas99s.domain.repository.Products;
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
    public  CommandLineRunner commandLineRunner(@Autowired Clients clients, @Autowired Products products , @Autowired CargoRepository cargoRepository){
return args -> {
  clients.save( new Cliente("Geovane Chivas"));
    clients.save( new Cliente("Marco"));

    products.save(new Produto(null, "Apex Game", new BigDecimal(1.222)));
    products.save(new Produto(null, "MobX", new BigDecimal(2.2)));
    products.save(new Produto(null, "God of War", new BigDecimal(4.2)));

    cargoRepository.save(new Cargo("Admin"));
    cargoRepository.save(new Cargo("User"));

};
    }
    public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
    }
}