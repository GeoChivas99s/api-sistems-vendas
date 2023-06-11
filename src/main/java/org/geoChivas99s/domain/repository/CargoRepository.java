package org.geoChivas99s.domain.repository;

import org.geoChivas99s.domain.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CargoRepository extends JpaRepository<Cargo, UUID> {
    Cargo findByNome(String nome);

}
