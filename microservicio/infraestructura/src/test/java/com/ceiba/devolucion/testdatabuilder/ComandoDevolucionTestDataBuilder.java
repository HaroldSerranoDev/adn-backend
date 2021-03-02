package com.ceiba.devolucion.testdatabuilder;

import com.ceiba.devolucion.comando.ComandoDevolucion;

public class ComandoDevolucionTestDataBuilder {

    private Long id;
    private Integer kilometrosFinales;
    private Long idAlquiler;


    public ComandoDevolucionTestDataBuilder() {
        this.id = 0L;
        this.kilometrosFinales = 250;
        this.idAlquiler = 1L;
    }

    public ComandoDevolucionTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoDevolucionTestDataBuilder conKilometrosFinales(Integer kilometrosFinales) {
        this.kilometrosFinales = kilometrosFinales;
        return this;
    }

    public ComandoDevolucionTestDataBuilder conIdAlquiler(Long idAlquiler) {
        this.idAlquiler = idAlquiler;
        return this;
    }


    public ComandoDevolucion build() {
        return new ComandoDevolucion(id, kilometrosFinales, idAlquiler);
    }
}
