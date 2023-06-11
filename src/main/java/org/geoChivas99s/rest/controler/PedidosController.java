package org.geoChivas99s.rest.controler;

import org.geoChivas99s.domain.entity.Pedido;
import org.geoChivas99s.rest.dto.PedidoDTO;
import org.geoChivas99s.service.PedidosService;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.*;
@RestController
@RequestMapping("/api/pedidos")
public class PedidosController {
    private PedidosService pedidosService;

    public PedidosController(PedidosService pedidosService) {
        this.pedidosService = pedidosService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody PedidoDTO dto){
       Pedido pedido = pedidosService.salvar(dto);
       return pedido.getId();
    }
}
