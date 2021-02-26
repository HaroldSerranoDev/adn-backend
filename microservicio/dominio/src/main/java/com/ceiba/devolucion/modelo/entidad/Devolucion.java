package com.ceiba.devolucion.modelo.entidad;


import com.ceiba.alquiler.modelo.entidad.Alquiler;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Devolucion {
    private Long id;
    private LocalDate fechaDevolucion;
    private int kilometrosFinales;
    private Alquiler alquiler;

    public Devolucion(Long id, String fechaDeolucion, int kilometrosFinales, Alquiler alquiler) {
        this.id = id;
//        this.fechaDevolucion = fechaDeolucion;
        this.kilometrosFinales = kilometrosFinales;
        this.alquiler = alquiler;
    }
}
