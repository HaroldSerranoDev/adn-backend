package com.ceiba.moto.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoMoto {

    private Long id;
    private String matricula;
    private String marca;
    private Integer modelo;
    private String tipoMoto;
    private Integer kilometrosRecorridos;
    private Double precioAlquiler;
}
