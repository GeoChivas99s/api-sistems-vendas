package org.geoChivas99s.rest.controler;

import org.geoChivas99s.domain.entity.Cliente;
import org.geoChivas99s.domain.entity.Produto;
import org.geoChivas99s.domain.repository.Products;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/products")
public class ProductController {
    private Products products;
    public ProductController(Products products) {
        this.products = products;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Produto produto){
        products.save(produto);
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable Integer id){
        return products.findById(id)
                .orElseThrow(()->
                        new ResponseStatusException
                                (HttpStatus.NOT_FOUND, "Cliente não encontrado!"));

    }

    @GetMapping
    public List<Produto> getAll(Produto query){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(query, matcher);
        return products.findAll(example);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Integer id){
        Optional<Produto> produto =  products.findById(id);
        if(produto.isPresent()){
            products.delete(produto.get());
            return  ResponseEntity.noContent().build();

        }
        return ResponseEntity.notFound().build();
    }

}



