//package com.ceiba.cliente.testdatabuilder;
//
//import com.ceiba.cliente.comando.ComandoCliente;
//import com.ceiba.cliente.modelo.entidad.Cliente;
//import com.ceiba.usuario.comando.ComandoUsuario;
//
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//public class ComandoClienteTestDataBuilder {
//
//    private Long id;
//    private String nombre;
//    private String direccion;
//    private String telefono;
//    private String cedula;
//    private String correo;
//
//
//
//    public ComandoClienteTestDataBuilder() {
//        this.id = 0L;
//        this.nombre = "test";
//        this.direccion = "calle 32 # 24 - 07";
//        this.telefono = "3127568249";
//        this.cedula = "1113685974";
//        this.correo = "test@gmail.com";
//    }
//
//    public ComandoClienteTestDataBuilder conId(Long id) {
//        this.id = id;
//        return this;
//    }
//
//    public ComandoClienteTestDataBuilder conNombre(String nombre) {
//        this.nombre = nombre;
//        return this;
//    }
//
//    public ComandoClienteTestDataBuilder conDireccion(String direccion) {
//        this.direccion = direccion;
//        return this;
//    }
//
//    public ComandoClienteTestDataBuilder conTelefono(String telefono) {
//        this.telefono = telefono;
//        return this;
//    }
//
//    public ComandoClienteTestDataBuilder conCedula(String cedula) {
//        this.cedula = cedula;
//        return this;
//    }
//
//    public ComandoClienteTestDataBuilder conCorreo(String correo) {
//        this.correo = correo;
//        return this;
//    }
//
//
//    public ComandoCliente build() {
//        return new ComandoCliente(id, nombre,direccion,telefono,cedula,correo);
//    }
//}
