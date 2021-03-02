package com.ceiba.devolucion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoDevolucion {

    private Long id;
    private int kilometrosFinales;
    private Long idAlquiler;
}
