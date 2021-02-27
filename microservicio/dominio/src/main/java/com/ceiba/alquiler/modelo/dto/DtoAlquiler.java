package com.ceiba.alquiler.modelo.dto;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.moto.modelo.dto.DtoMoto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoAlquiler {
    private Long id;
    private LocalDate fechaAlquiler;
    private LocalDate fechaEntrega;
    private DtoCliente cliente;
    private DtoMoto moto;
    private double valorPago;
}
