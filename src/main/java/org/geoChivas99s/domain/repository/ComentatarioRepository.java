package org.geoChivas99s.domain.repository;

import org.geoChivas99s.domain.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ComentatarioRepository  extends JpaRepository<Comentario, UUID> {
}
