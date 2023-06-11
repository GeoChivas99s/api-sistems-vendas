package org.geoChivas99s.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="colaboradores")
public class Colaborator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "salario")
    private Long Salario;

    @OneToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

}
