package com.ceiba.moto.modelo.dto;

import com.ceiba.moto.modelo.entidad.Marca;
import com.ceiba.moto.modelo.entidad.TipoMoto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoMoto {
    private Long id;
    private String matricula;
    private Marca marcaEnum;
    private int modelo;
    private TipoMoto tipoMotoEnum;
    private int kilometros_recorridos;
    private double precioAlquiler;

}
