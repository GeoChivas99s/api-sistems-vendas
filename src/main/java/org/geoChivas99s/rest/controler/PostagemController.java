package org.geoChivas99s.rest.controler;


import org.geoChivas99s.domain.entity.Postagem;
import org.geoChivas99s.domain.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/postagem")
public class PostagemController {
    @Autowired
    PostagemRepository postagemRepository;

    @GetMapping
     public Iterable<Postagem> getAll(){
         return postagemRepository.findAll();
     }

    @PostMapping
    public Postagem savePost(@RequestBody Postagem postagem){

        return  postagemRepository.save(postagem);
    }
}
