package org.geoChivas99s.service;

import org.geoChivas99s.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.geoChivas99s.repository.ClientRepository;
@Service
public class ClientServices {

    private ClientRepository repository;
    @Autowired  // podemos usar ou não essa notação pq na nova versão do spring ele detecta automaticamente
    public ClientServices(ClientRepository repository){
        this.repository = repository;
    }
    public  void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);
    }
    public  void validarCliente(Cliente cliente){
//aplicar validação louca
    }

}
