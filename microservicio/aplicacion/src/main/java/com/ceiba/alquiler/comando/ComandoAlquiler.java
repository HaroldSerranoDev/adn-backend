package com.ceiba.alquiler.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAlquiler {

    private Long id;
    private String fechaAlquiler;
    private String fechaEntrega;
    private Long idCliente;
    private Long idMoto;
}
