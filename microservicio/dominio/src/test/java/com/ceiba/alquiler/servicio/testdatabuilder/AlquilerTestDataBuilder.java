package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.alquiler.modelo.entidad.Alquiler;

public class AlquilerTestDataBuilder {
    private static final String  FECHA_ALQUILER ="2021-03-03";
    private static final String  FECHA_ENTREGA ="2021-03-08";

    private Long id;
    private String fechaAlquiler;
    private String fechaEntrega;
    private Long idCliente;
    private Long idMoto;

    public AlquilerTestDataBuilder() {
        this.id = 0L;
        this.fechaAlquiler = FECHA_ALQUILER;
        this.fechaEntrega = FECHA_ENTREGA;
        this.idCliente = 1L;
        this.idMoto = 1L;
    }

    public AlquilerTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public AlquilerTestDataBuilder conFechaAlquiler(String fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
        return this;
    }

    public AlquilerTestDataBuilder conFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
        return this;
    }

    public AlquilerTestDataBuilder conIdCliente(Long idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public AlquilerTestDataBuilder conIdMoto(Long idMoto) {
        this.idMoto = idMoto;
        return this;
    }

    public Alquiler build() {
        return new Alquiler(id, fechaAlquiler,fechaEntrega,idCliente,idMoto);
    }
}
