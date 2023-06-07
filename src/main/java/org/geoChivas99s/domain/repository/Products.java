package org.geoChivas99s.domain.repository;

import org.geoChivas99s.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Products extends JpaRepository<Produto, Integer> {
}
