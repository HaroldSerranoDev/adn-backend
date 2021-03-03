package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.moto.modelo.dto.DtoMoto;

import java.time.LocalDate;

public class DtoAlquilerTestDataBuilder {

    private Long id;
    private LocalDate fechaAlquiler;
    private LocalDate fechaEntrega;
    private DtoCliente cliente;
    private DtoMoto moto;
    private Double valorPago;

    public DtoAlquilerTestDataBuilder() {
        this.id = 1L;
        this.fechaAlquiler = LocalDate.now().minusDays(2);
        this.fechaEntrega = LocalDate.now();
        this.cliente = null;
        this.moto = null;
        this.valorPago = 25000D;
    }

    public DtoAlquilerTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public DtoAlquilerTestDataBuilder conFechaDeAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
        return this;
    }
    public DtoAlquilerTestDataBuilder conFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
        return this;
    }
    public DtoAlquilerTestDataBuilder conCliente(DtoCliente cliente) {
        this.cliente = cliente;
        return this;
    }
    public DtoAlquilerTestDataBuilder conMoto(DtoMoto moto) {
        this.moto = moto;
        return this;
    }
    public DtoAlquilerTestDataBuilder conValorPago(Double valorPago) {
        this.valorPago = valorPago;
        return this;
    }

    public DtoAlquiler build() {
        return new DtoAlquiler(id, fechaAlquiler, fechaEntrega, cliente, moto, valorPago);
    }

}
