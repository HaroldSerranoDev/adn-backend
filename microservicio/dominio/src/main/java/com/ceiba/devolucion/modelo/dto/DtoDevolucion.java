package com.ceiba.devolucion.modelo.dto;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoDevolucion {
    private Long id;
    private LocalDate fechaDevolucion;
    private int kilometrosFinales;
    private Alquiler alquiler;

}
