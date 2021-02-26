package com.ceiba.alquiler.modelo.entidad;


import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.moto.modelo.entidad.Moto;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Alquiler {

    private Long id;
    private LocalDate fechaAlquiler;
    private LocalDate fechaEntrega;
    private Cliente cliente;
    private Moto moto;
    private double valorPago;

    public Alquiler(Long id, String fechaAlquiler, String fechaEntrega, Cliente cliente, Moto moto, double valorPago) {
        this.id = id;
//        this.fechaAlquiler = fechaAlquiler;
//        this.fechaEntrega = fechaEntrega;
        this.cliente = cliente;
        this.moto = moto;
        this.valorPago = valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
