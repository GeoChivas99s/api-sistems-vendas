package org.geoChivas99s.rest.controler;

import org.geoChivas99s.domain.entity.Cargo;
import org.geoChivas99s.domain.entity.Cliente;
import org.geoChivas99s.domain.repository.CargoRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "/api/cargos")
public class CargoController {


    private CargoRepository cargoRepository;

    public CargoController(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }


    @PostMapping
    @ResponseStatus(CREATED)
    public Cargo save(@RequestBody Cargo cargo){

     Cargo existsCargo = cargoRepository.findByNome(cargo.getNome().toUpperCase());
     if(existsCargo != null) {
         throw  new RuntimeException("Cargo já existe!");
     }

        Cargo newCargo  = new Cargo();
        newCargo.setNome(cargo.getNome().toUpperCase());
               return cargoRepository.save(newCargo);


    }
    @GetMapping
    public Iterable<Cargo> getAll(){

       return cargoRepository.findAll();

    }

    @PutMapping("/{id}")
    public  Cargo update(@PathVariable UUID id, @RequestBody Cargo cargo){

    Optional<Cargo> cargo1 =  cargoRepository.findById(id);
    if(!cargo1.isPresent()){
        throw new RuntimeException("Cargo inexistente");

    }
    Cargo updatedCargo = new Cargo();
    updatedCargo.setCargo_id(id);
    updatedCargo.setNome(cargo.getNome());
    return cargoRepository.save(updatedCargo);


    }

}
