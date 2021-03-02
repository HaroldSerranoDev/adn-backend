package com.ceiba.devolucion.modelo.entidad;


import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Devolucion {

    private static final String DEBE_INGRESAR_LOS_KILOMETROS_FINALES_DE_LA_MOTO = "Debe ingresar los kilometros finales de la moto.";
    private static final String DEBE_INGRESAR_EL_IDENTIFICADOR_DEL_ALQUILER = "Debe ingresar el identificador del alquiler.";


    private Long id;
    private LocalDate fechaDevolucion;
    private int kilometrosFinales;
    private Long idAlquiler;
    private double valorPagoFinal;

    public Devolucion(Long id, Integer kilometrosFinales, Long idAlquiler) {

        validarObligatorio(kilometrosFinales, DEBE_INGRESAR_LOS_KILOMETROS_FINALES_DE_LA_MOTO);
        validarObligatorio(idAlquiler, DEBE_INGRESAR_EL_IDENTIFICADOR_DEL_ALQUILER);

        this.id = id;
        this.fechaDevolucion = LocalDate.now();
        this.valorPagoFinal = 0;
        this.kilometrosFinales = kilometrosFinales;
        this.idAlquiler = idAlquiler;
    }

    public void setValorPagoFinal(double valorPagoFinal) {
        this.valorPagoFinal = valorPagoFinal;
    }
}
