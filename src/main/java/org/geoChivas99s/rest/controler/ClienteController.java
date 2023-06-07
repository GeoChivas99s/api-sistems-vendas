package org.geoChivas99s.rest.controler;


import org.geoChivas99s.domain.entity.Cliente;
import org.geoChivas99s.domain.repository.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/api/clientes")
public class ClienteController {
  //  @RequestMapping(value = "/hello/{nome}", method = RequestMethod.GET
   // consumes = {"application/json" , "application/xml"} ,// Tipo que posso receber
   // produces = {"application/json" , "application/xml"} // o valor que ele vai enviar
    //)

    private Clients clientes;

    public ClienteController(Clients clientes) {
        this.clientes = clientes;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity getClientById(@PathVariable Integer id){
        Optional<Cliente> cliente =  clientes.findById(id);
         if(cliente.isPresent()){
         return ResponseEntity.ok(cliente.get());
         }
            return ResponseEntity.notFound().build();

    }






}
