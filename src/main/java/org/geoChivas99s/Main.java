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
   public CommandLineRunner init(@Autowired Clients clients , @Autowired Pedidos pedidos){
       return args -> {
           Cliente c1 = new Cliente("Lindo Mesmo");
           Cliente c2 = new Cliente("Marco Pitra");

          clients.save(c1);
          clients.save(c2);

           Pedido p = new Pedido();
           p.setCliente(c1);
           p.setDataPedido(LocalDate.now());
           p.setTotal(BigDecimal.valueOf(10.00));

           pedidos.save(p);



           System.out.println("--------+----------------");

           clients.delete(c2);
           clients.findAll().forEach(e-> System.out.println(e.getNome()));
          clients.findByNomeLike("");
         Cliente c33 =  clients.findClienteFetch(c1.getId());

           System.out.println(c33);
           System.out.println(c33.getPedidos());

           System.out.println("/***-----*-");

          // pedidos.findByCliente(c1).forEach(System.out::println);

       };

   }
    public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
    }
}