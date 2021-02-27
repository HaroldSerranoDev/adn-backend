package com.ceiba.moto.modelo.entidad;


import lombok.Getter;

@Getter
public class Moto {

    private Long id;
    private String matricula;
    private Marca marca;
    private int modelo;
    private TipoMoto tipoMoto;
    private int kilometrosRecorridos;
    private double precioAlquiler;

    public Moto(Long id, String matricula, Marca marca, int modelo, TipoMoto tipoMoto, int kilometrosRecorridos, double precioAlquiler) {
        this.id = id;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoMoto = tipoMoto;
        this.kilometrosRecorridos = kilometrosRecorridos;
        this.precioAlquiler = precioAlquiler;
    }

    public void setKilometrosRecorridos(int kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }
}
