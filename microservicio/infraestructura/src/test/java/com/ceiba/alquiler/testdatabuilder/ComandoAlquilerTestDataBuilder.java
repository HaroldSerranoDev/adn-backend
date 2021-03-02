package com.ceiba.alquiler.testdatabuilder;

import com.ceiba.alquiler.comando.ComandoAlquiler;

public class ComandoAlquilerTestDataBuilder {

    private Long id;
    private String fechaAlquiler;
    private String fechaEntrega;
    private Long idCliente;
    private Long idMoto;


    public ComandoAlquilerTestDataBuilder() {
        this.id = 0L;
        this.fechaAlquiler = "2021-03-06";
        this.fechaEntrega = "2021-03-09";
        this.idCliente = 1L;
        this.idMoto = 1L;
    }

    public ComandoAlquilerTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoAlquilerTestDataBuilder conFechaAlquiler(String fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
        return this;
    }

    public ComandoAlquilerTestDataBuilder conFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
        return this;
    }

    public ComandoAlquilerTestDataBuilder conIdCliente(Long idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public ComandoAlquilerTestDataBuilder conIdMoto(Long idMoto) {
        this.idMoto = idMoto;
        return this;
    }

    public ComandoAlquiler build() {
        return new ComandoAlquiler(id, fechaAlquiler, fechaEntrega, idCliente, idMoto);
    }
}
