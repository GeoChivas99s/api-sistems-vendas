package org.geoChivas99s.domain.entity;

import javax.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="nome", length = 100)
    private String nome;

    public Cliente(){

    }
    public Cliente(String nome , Integer id){
setNome(nome);
setId(id);
    }
    public Cliente(String nome ){
        setNome(nome);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
