package com.ceiba.devolucion.modelo.dto;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoDevolucion {
    private Long id;
    private LocalDate fechaDevolucion;
    private int kilometrosFinales;
    private DtoAlquiler alquiler;
    private double valorPagoFinal;
}
