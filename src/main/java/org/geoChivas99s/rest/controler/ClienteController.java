package org.geoChivas99s.rest.controler;


import org.geoChivas99s.domain.entity.Cliente;
import org.geoChivas99s.domain.repository.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    private Clients clientes;

    public ClienteController(Clients clientes) {
        this.clientes = clientes;
    }

    @GetMapping("/{id}")
    public Cliente getClientById(@PathVariable Integer id){
     return clientes.findById(id)
                .orElseThrow(()->
                 new ResponseStatusException
                         (HttpStatus.NOT_FOUND, "Cliente não encontrado!"));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente cliente){
        return  clientes.save(cliente);

    }
    /*
    @GetMapping
    @ResponseBody
    public ResponseEntity getAll(){
        List<Cliente> clientList =  clientes.findAll();
        return  ResponseEntity.ok(clientList);
    }
*/
    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Integer id){
        Optional<Cliente> cliente =  clientes.findById(id);
       if(cliente.isPresent()){
           clientes.delete(cliente.get());
      return  ResponseEntity.noContent().build();

       }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/{id}")
    public  void update(@PathVariable Integer id ,   @RequestBody Cliente cliente){
          clientes.findById(id)
                .map(cl -> {
                    cliente.setId(cl.getId());
                    clientes.save(cliente);
                    return  cl;
                }).orElseThrow( () -> new ResponseStatusException
                        (HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }


    @GetMapping
    public List<Cliente>  find(Cliente query){
    ExampleMatcher matcher = ExampleMatcher
            .matching()
            .withIgnoreCase()
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example example = Example.of(query, matcher);
        return clientes.findAll(example);

  }
}