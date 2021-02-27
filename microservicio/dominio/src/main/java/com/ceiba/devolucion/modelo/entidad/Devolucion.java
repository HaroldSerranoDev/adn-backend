package com.ceiba.devolucion.modelo.entidad;


import com.ceiba.alquiler.modelo.entidad.Alquiler;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
public class Devolucion {
    private Long id;
    private LocalDate fechaDevolucion;
    private int kilometrosFinales;
    private Long idAlquiler;

    public Devolucion(Long id, String fechaDevolucion, int kilometrosFinales, Long idAlquiler) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaDevolucionFinal = LocalDate.parse(fechaDevolucion,formatter);

        this.id = id;
        this.fechaDevolucion = fechaDevolucionFinal;
        this.kilometrosFinales = kilometrosFinales;
        this.idAlquiler = idAlquiler;
    }
}
