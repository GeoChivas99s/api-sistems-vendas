package org.geoChivas99s.domain.repository;

import org.geoChivas99s.domain.entity.Cliente;
import org.geoChivas99s.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface Pedidos extends JpaRepository <Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);

}
