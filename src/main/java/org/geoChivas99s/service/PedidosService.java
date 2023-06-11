package org.geoChivas99s.service;

import org.geoChivas99s.domain.entity.Pedido;
import org.geoChivas99s.rest.dto.PedidoDTO;

public interface PedidosService {

    Pedido salvar(PedidoDTO dto);

}
