package org.geoChivas99s.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorDTO {

    private String nome;
    private Long salario;
    private UUID cargo_id;

}
