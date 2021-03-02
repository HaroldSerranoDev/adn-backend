package com.ceiba.cliente.modelo.entidad;


import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Cliente {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE = "Se debe ingresar el nombre del cliente";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION_DEL_CLIENTE = "Se debe ingresar la direccion del cliente";
    private static final String SE_DEBE_INGRESAR_EL_TELEFONO_DEL_CLIENTE = "Se debe ingresar el telefono del cliente";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA_DEL_CLIENTE = "Se debe ingresar la cédula del cliente";
    private static final String SE_DEBE_INGRESAR_EL_CORREO_DEL_CLIENTE = "Se debe ingresar el correo del cliente";
    private static final String DEBE_INGRESAR_UN_VALOR_NUMERICO_PARA_EL_TELEFONO = "Debe ingresar un valor númerico para el telefono";
    private static final String DEBE_INGRESAR_UN_VALOR_NUMERICO_PARA_LA_CEDULA = "Debe ingresar un valor númerico para la cédula";
    private static final String DEBE_INGRESAR_UN_FORMATO_DE_CORREO_VALIDO = "Debe ingresar un formato de correo válido";
    private static final String REGEX_CORREO = "^(.+)@(.+)$";
    private static final int LONGITUD_MINIMA_DE_DATOS = 1;


    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String cedula;
    private String correo;


    public Cliente(Long id, String nombre, String direccion, String telefono, String cedula, String correo) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE);
        validarObligatorio(direccion, SE_DEBE_INGRESAR_LA_DIRECCION_DEL_CLIENTE);
        validarObligatorio(telefono, SE_DEBE_INGRESAR_EL_TELEFONO_DEL_CLIENTE);
        validarObligatorio(cedula, SE_DEBE_INGRESAR_LA_CEDULA_DEL_CLIENTE);
        validarObligatorio(correo, SE_DEBE_INGRESAR_EL_CORREO_DEL_CLIENTE);

        validarLongitud(nombre, LONGITUD_MINIMA_DE_DATOS, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE);
        validarLongitud(direccion, LONGITUD_MINIMA_DE_DATOS, SE_DEBE_INGRESAR_LA_DIRECCION_DEL_CLIENTE);
        validarLongitud(telefono, LONGITUD_MINIMA_DE_DATOS, SE_DEBE_INGRESAR_EL_TELEFONO_DEL_CLIENTE);
        validarLongitud(cedula, LONGITUD_MINIMA_DE_DATOS, SE_DEBE_INGRESAR_LA_CEDULA_DEL_CLIENTE);
        validarLongitud(correo, LONGITUD_MINIMA_DE_DATOS, SE_DEBE_INGRESAR_EL_CORREO_DEL_CLIENTE);

        validarNumerico(cedula, DEBE_INGRESAR_UN_VALOR_NUMERICO_PARA_LA_CEDULA);
        validarNumerico(telefono, DEBE_INGRESAR_UN_VALOR_NUMERICO_PARA_EL_TELEFONO);

        validarRegex(correo, REGEX_CORREO, DEBE_INGRESAR_UN_FORMATO_DE_CORREO_VALIDO);

        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cedula = cedula;
        this.correo = correo;
    }
}
