package com.ceiba.moto.modelo.entidad;


import lombok.Getter;

@Getter
public class Moto {

    private Long id;
    private String matricula;
    private Marca marcaEnum;
    private int modelo;
    private TipoMoto tipoMotoEnum;
    private int kilometros_recorridos;
    private double precioAlquiler;

    public Moto(Long id, String matricula, Marca marcaEnum, int modelo, TipoMoto tipoMotoEnum, double precioAlquiler) {
        this.id = id;
        this.matricula = matricula;
        this.marcaEnum = marcaEnum;
        this.modelo = modelo;
        this.tipoMotoEnum = tipoMotoEnum;
        this.kilometros_recorridos = 0;
        this.precioAlquiler = precioAlquiler;
    }

    public void setKilometros_recorridos(int kilometros_recorridos) {
        this.kilometros_recorridos = kilometros_recorridos;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }
}
