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
@Table(name="cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cargo_id")
    private UUID cargo_id;

    @Column(name = "nome")
    private String nome;

    public Cargo(String nome){
        this.setNome(nome);
    }

}
