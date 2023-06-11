package org.geoChivas99s.rest.controler;

import org.geoChivas99s.domain.entity.Colaborator;
import org.geoChivas99s.domain.repository.ColaboratorRepository;
import org.geoChivas99s.rest.dto.ColaboradorDTO;
import org.geoChivas99s.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/colaboradores")
public class CollaboradorController {


    ColaboratorRepository colaboratorRepository;
    ColaboradorService colaboradorService;

    public CollaboradorController(ColaboratorRepository colaboratorRepository, ColaboradorService colaboradorService) {
        this.colaboratorRepository = colaboratorRepository;
        this.colaboradorService = colaboradorService;
    }

    @GetMapping
    public Iterable<Colaborator> getAll(){

       return colaboratorRepository.findAll();
    }
    @PostMapping
    public Colaborator saveCollaborator(@RequestBody ColaboradorDTO colaboradorDTO){

        return colaboradorService.saveCollaborator(colaboradorDTO);
    }


    @DeleteMapping("/{id}")
    public void deleteCollaborator(@PathVariable UUID id){
      Colaborator colaborator =  colaboratorRepository.findById(id).orElseThrow(()-> new RuntimeException("Colaborador Inexistente"));

        colaboratorRepository.delete(colaborator);

    }



}
