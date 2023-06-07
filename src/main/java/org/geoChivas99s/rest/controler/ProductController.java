package org.geoChivas99s.rest.controler;

import org.geoChivas99s.domain.entity.Produto;
import org.geoChivas99s.domain.repository.Products;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        products.save(produto);.

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

    }



