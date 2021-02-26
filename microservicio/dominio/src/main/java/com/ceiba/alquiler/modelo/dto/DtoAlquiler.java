package com.ceiba.alquiler.modelo.dto;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.moto.modelo.entidad.Moto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoAlquiler {
    private Long id;
    private LocalDate fechaAlquiler;
    private LocalDate fechaEstimadaEntrega;
    private Cliente cliente;
    private Moto moto;
    private double valorPago;

}
