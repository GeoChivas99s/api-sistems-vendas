package org.geoChivas99s.service;

import lombok.RequiredArgsConstructor;
import org.geoChivas99s.domain.entity.Cargo;
import org.geoChivas99s.domain.entity.Colaborator;
import org.geoChivas99s.domain.repository.CargoRepository;
import org.geoChivas99s.domain.repository.ColaboratorRepository;
import org.geoChivas99s.rest.dto.ColaboradorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ColaboradorService {


    @Autowired
  private   ColaboratorRepository colaboratorRepository;
    @Autowired
  private CargoRepository cargoRepository;


    @Transactional
    public Colaborator saveCollaborator(ColaboradorDTO colaboradorDTO){

       Cargo cargo =  cargoRepository.findById(colaboradorDTO.getCargo_id()).orElseThrow( ()-> new RuntimeException("Cargo Inexisrtente!!"));

       Colaborator colaborator = new Colaborator();
       colaborator.setCargo(cargo);
       colaborator.setNome(colaboradorDTO.getNome());
       colaborator.setSalario(colaboradorDTO.getSalario());
        System.out.println(colaborator);
     return colaboratorRepository.save(colaborator);

    }
}
