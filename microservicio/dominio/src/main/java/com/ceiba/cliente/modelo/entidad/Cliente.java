package com.ceiba.cliente.modelo.entidad;


import lombok.Getter;

@Getter
public class Cliente {

    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String cedula;
    private String correo;


    public Cliente(Long id, String nombre, String direccion, String telefono, String cedula, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cedula = cedula;
        this.correo = correo;
    }
}
