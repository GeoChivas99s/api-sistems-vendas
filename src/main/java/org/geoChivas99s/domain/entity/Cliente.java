package org.geoChivas99s.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="nome", length = 100)
    private String nome;

    @Column(name = "cpf" , length = 11)
    private String cpf;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos;

    public Cliente(String nome) {
        this.nome= nome;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Cliente(String nome , Integer id){
setNome(nome);
setId(id);
    }


}
