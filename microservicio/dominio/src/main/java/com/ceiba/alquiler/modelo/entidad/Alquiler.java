package com.ceiba.alquiler.modelo.entidad;


import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
public class Alquiler {

    private Long id;
    private LocalDate fechaAlquiler;
    private LocalDate fechaEntrega;
    private Long idCliente;
    private Long idMoto;
    private double valorPago;

    public Alquiler(Long id, String fechaAlquiler, String fechaEntrega, Long idCliente, Long idMoto) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaAlquilerFinal = LocalDate.parse(fechaAlquiler,formatter);
        LocalDate fechaEntregaFinal = LocalDate.parse(fechaEntrega,formatter);

        this.id = id;
        this.fechaAlquiler = fechaAlquilerFinal;
        this.fechaEntrega = fechaEntregaFinal;
        this.idCliente = idCliente;
        this.idMoto = idMoto;
        this.valorPago = 0;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
