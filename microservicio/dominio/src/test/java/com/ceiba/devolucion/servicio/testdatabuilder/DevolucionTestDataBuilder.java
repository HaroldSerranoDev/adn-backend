package com.ceiba.devolucion.servicio.testdatabuilder;

import com.ceiba.devolucion.modelo.entidad.Devolucion;

import java.time.LocalDate;

public class DevolucionTestDataBuilder {
    private static final String  FECHA_DEVOLUCION ="2021-03-03";

    private Long id;
    private Integer kilometrosFinales;
    private Long idAlquiler;


    public DevolucionTestDataBuilder() {
        this.id = 0L;
        this.kilometrosFinales = 0;
        this.idAlquiler = 1L;
    }

    public DevolucionTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public DevolucionTestDataBuilder conKilometrosFinales(Integer kilometrosFinales) {
        this.kilometrosFinales = kilometrosFinales;
        return this;
    }

    public DevolucionTestDataBuilder conIdalquiler(Long idAlquiler) {
        this.idAlquiler = idAlquiler;
        return this;
    }

    public Devolucion build() {
        return new Devolucion(id, kilometrosFinales, idAlquiler);
    }
}
