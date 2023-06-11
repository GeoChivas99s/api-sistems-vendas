package org.geoChivas99s.domain.repository;

import org.geoChivas99s.domain.entity.Colaborator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ColaboratorRepository extends JpaRepository<Colaborator, UUID> {
}
