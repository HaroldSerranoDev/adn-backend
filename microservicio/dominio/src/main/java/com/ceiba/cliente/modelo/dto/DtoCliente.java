package com.ceiba.cliente.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCliente {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String cedula;
    private String correo;
}
