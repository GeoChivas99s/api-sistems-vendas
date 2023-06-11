package org.geoChivas99s.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "comentario")
public class Comentario{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "autor")
    private String autor;
    @Column(name = "texto")
    private String texto;


}
