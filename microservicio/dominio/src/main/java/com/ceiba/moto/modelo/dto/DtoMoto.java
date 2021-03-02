package com.ceiba.moto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoMoto {
    private Long id;
    private String matricula;
    private String marca;
    private int modelo;
    private String tipoMoto;
    private int kilometros_recorridos;
    private double precioAlquiler;

}
