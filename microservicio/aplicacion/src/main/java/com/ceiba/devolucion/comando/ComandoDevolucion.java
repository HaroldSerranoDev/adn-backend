package com.ceiba.devolucion.comando;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoDevolucion {

    private Long id;
    private String fechaDevolucion;
    private int kilometrosFinales;
    private Long idAlquiler;
}
