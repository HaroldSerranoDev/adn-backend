package com.ceiba.moto.comando;

import com.ceiba.moto.modelo.entidad.Marca;
import com.ceiba.moto.modelo.entidad.TipoMoto;
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
    private Marca marca;
    private int modelo;
    private TipoMoto tipoMoto;
    private int kilometrosRecorridos;
    private double precioAlquiler;
}
