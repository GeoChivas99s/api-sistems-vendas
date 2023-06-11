package org.geoChivas99s.domain.repository;

import org.geoChivas99s.domain.entity.Colaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ColaboratorRepository extends JpaRepository<Colaborator, UUID> {
}
