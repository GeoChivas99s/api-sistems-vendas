package org.geoChivas99s.domain.repository;

import org.geoChivas99s.domain.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CargoRepository extends JpaRepository<Cargo, UUID> {
    Cargo findByNome(String nome);

}
