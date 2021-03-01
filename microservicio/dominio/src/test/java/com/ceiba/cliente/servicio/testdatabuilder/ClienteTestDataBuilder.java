package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;

public class ClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String cedula;
    private String correo;

    public ClienteTestDataBuilder() {
        this.id = 0L;
        this.nombre = "test";
        this.direccion = "calle 32 # 24 - 07";
        this.telefono = "3127568249";
        this.cedula = "1113685974";
        this.correo = "test@gmail.com";
    }

    public ClienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ClienteTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ClienteTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public ClienteTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public ClienteTestDataBuilder conCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public ClienteTestDataBuilder conCorreo(String correo) {
        this.correo = correo;
        return this;
    }


    public Cliente build() {
        return new Cliente(id, nombre,direccion,telefono,cedula,correo);
    }
}
