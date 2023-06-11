package org.geoChivas99s.service.impl;

import lombok.RequiredArgsConstructor;
import org.geoChivas99s.domain.entity.Cliente;
import org.geoChivas99s.domain.entity.ItemPedido;
import org.geoChivas99s.domain.entity.Pedido;
import org.geoChivas99s.domain.entity.Produto;
import org.geoChivas99s.domain.repository.Clients;
import org.geoChivas99s.domain.repository.ItemPedidos;
import org.geoChivas99s.domain.repository.Pedidos;
import org.geoChivas99s.domain.repository.Products;
import org.geoChivas99s.exception.BussinessRulesException;
import org.geoChivas99s.rest.dto.ItemPedidoDTO;
import org.geoChivas99s.rest.dto.PedidoDTO;
import org.geoChivas99s.service.PedidosService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidosService {
    private final Pedidos pedidos;
    private final Clients clients;
    private final Products products;
    private final ItemPedidos itemPedidos;


    @Transactional
    @Override
    public Pedido salvar(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        Cliente cliente = clients.findById(dto.getCliente()).orElseThrow(()-> new BussinessRulesException("CLiente não encontrado!"));
        pedido.setCliente(cliente);
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        List<ItemPedido> items =  convertItems(pedido , dto.getItems());
        pedidos.save(pedido);
        itemPedidos.saveAll(items);
        pedido.setItens(items);
        return pedido;
    }

    private List<ItemPedido> convertItems(Pedido pedido , List<ItemPedidoDTO> items){
        if(items.isEmpty()){
            throw new BussinessRulesException("Não é possível adicionar um pedido sem uma items");
        }
      return  items.stream().map(itemPedidoDTO -> {
                   Produto produto = products.
                           findById(itemPedidoDTO.getProduto())
                           .orElseThrow(()-> new BussinessRulesException("Código do produto inválido!!"  +itemPedidoDTO.getProduto()));

                  ItemPedido itemPedido = new ItemPedido();
                  itemPedido.setPedido(pedido);
                  itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());
                  itemPedido.setProduto(produto);
                  return itemPedido;
              }

                ).collect(Collectors.toList());
    }

}
