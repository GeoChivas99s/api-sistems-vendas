package org.geoChivas99s.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "postagens")
public class Postagem {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "texto")
    private String texto;

    @OneToMany
    @JoinColumn(name = "id_postagem")
    private List<Comentario> comentarios;

}
