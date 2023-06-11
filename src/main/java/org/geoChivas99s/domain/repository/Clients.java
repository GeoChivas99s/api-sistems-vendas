package org.geoChivas99s.domain.repository;
import org.geoChivas99s.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface Clients  extends JpaRepository<Cliente, Integer> {

     List<Cliente> findByNomeLike (String nome);
@Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id ")
     Cliente findClienteFetch (Integer id);




}
