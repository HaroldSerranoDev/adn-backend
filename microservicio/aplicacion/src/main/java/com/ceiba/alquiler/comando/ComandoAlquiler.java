package com.ceiba.alquiler.comando;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.moto.modelo.entidad.Moto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ComandoAlquiler {

    private Long id;
    private String fechaAlquiler;
    private String fechaEntrega;
    private Long idCliente;
    private Long idMoto;
}
