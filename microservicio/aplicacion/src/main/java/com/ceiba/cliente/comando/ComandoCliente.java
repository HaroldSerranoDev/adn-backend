package com.ceiba.cliente.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCliente {

    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String cedula;
    private String correo;
}
