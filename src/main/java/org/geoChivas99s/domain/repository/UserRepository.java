package org.geoChivas99s.domain.repository;

import org.geoChivas99s.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findByLogin(String login);
}
