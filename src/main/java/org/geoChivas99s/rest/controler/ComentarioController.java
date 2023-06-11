package org.geoChivas99s.rest.controler;

import org.geoChivas99s.domain.entity.Comentario;
import org.geoChivas99s.domain.entity.Postagem;
import org.geoChivas99s.domain.repository.ComentatarioRepository;
import org.geoChivas99s.domain.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comentario")
public class ComentarioController {

    @Autowired
    ComentatarioRepository comentatarioRepository;

    @GetMapping
    public Iterable<Comentario> getAll(){
        return comentatarioRepository.findAll();
    }

    @PostMapping
    public Comentario saveComment(@RequestBody Comentario comentario){
        return  comentatarioRepository.save(comentario);
    }
}