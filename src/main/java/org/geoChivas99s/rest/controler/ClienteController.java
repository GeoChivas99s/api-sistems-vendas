package org.geoChivas99s.rest.controler;


import org.geoChivas99s.domain.entity.Cliente;
import org.geoChivas99s.domain.repository.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping
    @ResponseBody
    public ResponseEntity save(@RequestBody Cliente cliente){
      Cliente newClient =  clientes.save(cliente);
      return  ResponseEntity.ok(newClient);
    }
    @GetMapping
    @ResponseBody
    public ResponseEntity getAll(){
        List<Cliente> clientList =  clientes.findAll();
        return  ResponseEntity.ok(clientList);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity deleteClient(@PathVariable Integer id){
        Optional<Cliente> cliente =  clientes.findById(id);
       if(cliente.isPresent()){
           clientes.delete(cliente.get());
      return  ResponseEntity.noContent().build();

       }
        return ResponseEntity.notFound().build();
    }

    @ResponseBody
    @PutMapping("/{id}")
    public  ResponseEntity update(@PathVariable Integer id ,   @RequestBody Cliente cliente){
        return  clientes.findById(id)
                .map(cl -> {
                    cliente.setId(cl.getId());
                    clientes.save(cliente);
                    return  ResponseEntity.noContent().build();
                }).orElseGet( ()-> ResponseEntity.notFound().build() );
    }






}
