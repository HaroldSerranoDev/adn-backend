package com.ceiba.moto.modelo.entidad;


import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Moto {
    private static final String SE_DEBE_INGRESAR_LA_MATRICULA_DE_LA_MOTO = "Se debe ingresar la matricula de la moto";
    private static final String SE_DEBE_INGRESAR_LA_MARCA_DE_LA_MOTO = "Se debe ingresar la marca de la moto";
    private static final String SE_DEBE_INGRESAR_UNA_MARCA_VALIDA = "Se debe ingresar una marca de moto válida";
    private static final String SE_DEBE_INGRESAR_UN_MODELO_DE_MOTO_VALIDO = "Se debe ingresar un modelo de moto válido";
    private static final String SE_DEBE_INGRESAR_UN_MODELO_DE_MOTO = "Se debe ingresar un modelo de moto";
    private static final String SE_DEBE_INGRESAR_UN_MODELO_DE_MOTO_POSITIVO = "Se debe ingresar un modelo de moto positivo";
    private static final String SE_DEBE_INGRESAR_UN_TIPO_DE_MOTO_VALIDO = "Se debe ingresar un tipo de moto válido";
    private static final String SE_DEBE_INGRESAR_UN_TIPO_DE_MOTO = "Se debe ingresar un tipo de moto";
    private static final String DEBE_INGRESAR_UN_VALOR_POSITIVO_PARA_LOS_KILOMETROS_RECORRIDOS = "Debe ingresar un valor positivo para los kilometros recorridos";
    private static final String DEBE_INGRESAR_UN_VALOR_PARA_LOS_KILOMETROS_RECORRIDOS = "Debe ingresar un valor para los kilometros recorridos";
    private static final String DEBE_INGRESAR_UN_VALOR_POSITIVO_PARA_EL_PRECIO_DE_ALQUILER = "Debe ingresar un valor positivo para el precio de alquiler";
    private static final String DEBE_INGRESAR_UN_VALOR_PARA_EL_PRECIO_DE_ALQUILER = "Debe ingresar un valor para el precio de alquiler";
    private static final int LONGITUD_MINIMA_DE_DATOS = 1;
    private static final int LONGITUD_MINIMA_KILOMETROS_RECORRIDOS = 1;


    private Long id;
    private String matricula;
    private Marca marca;
    private int modelo;
    private TipoMoto tipoMoto;
    private int kilometrosRecorridos;
    private Double precioAlquiler;

    public Moto(Long id, String matricula, String marca, Integer modelo, String tipoMoto, Integer kilometrosRecorridos, Double precioAlquiler) {

        validarObligatorio(matricula, SE_DEBE_INGRESAR_LA_MATRICULA_DE_LA_MOTO);
        validarObligatorio(marca, SE_DEBE_INGRESAR_LA_MARCA_DE_LA_MOTO);
        validarObligatorio(modelo, SE_DEBE_INGRESAR_UN_MODELO_DE_MOTO);
        validarObligatorio(tipoMoto, SE_DEBE_INGRESAR_UN_TIPO_DE_MOTO);
        validarObligatorio(kilometrosRecorridos, DEBE_INGRESAR_UN_VALOR_PARA_LOS_KILOMETROS_RECORRIDOS);
        validarObligatorio(precioAlquiler, DEBE_INGRESAR_UN_VALOR_PARA_EL_PRECIO_DE_ALQUILER);

        validarLongitud(matricula, LONGITUD_MINIMA_DE_DATOS, SE_DEBE_INGRESAR_LA_MATRICULA_DE_LA_MOTO);
        validarLongitud(marca, LONGITUD_MINIMA_DE_DATOS, SE_DEBE_INGRESAR_LA_MARCA_DE_LA_MOTO);
        validarLongitud(tipoMoto, LONGITUD_MINIMA_DE_DATOS, SE_DEBE_INGRESAR_UN_TIPO_DE_MOTO);

        Marca marcaFinal = validarEnumValido(marca, Marca.class, SE_DEBE_INGRESAR_UNA_MARCA_VALIDA);
        TipoMoto tipoMotoFinal = validarEnumValido(tipoMoto, TipoMoto.class, SE_DEBE_INGRESAR_UN_TIPO_DE_MOTO_VALIDO);


        validarPositivo((double) modelo, SE_DEBE_INGRESAR_UN_MODELO_DE_MOTO_POSITIVO);
        validarPositivo((double) kilometrosRecorridos, DEBE_INGRESAR_UN_VALOR_POSITIVO_PARA_LOS_KILOMETROS_RECORRIDOS);
        validarPositivo(precioAlquiler, DEBE_INGRESAR_UN_VALOR_POSITIVO_PARA_EL_PRECIO_DE_ALQUILER);


        this.id = id;
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marcaFinal;
        this.tipoMoto = tipoMotoFinal;
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
