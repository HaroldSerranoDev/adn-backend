package com.ceiba.alquiler.modelo.entidad;


import com.ceiba.dominio.ValidadorArgumento;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Alquiler {

    private static final String FORMATO_FECHA = "yyyy-MM-dd";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_ALQUILER = "Se debe ingresar la fecha de alquiler";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_ENTREGA = "Se debe ingresar la fecha de entrega";
    private static final String FORMATO_DE_FECHA_DE_ALQUILER_INCORRECTO = "Formato de fecha de alquiler incorrecto";
    private static final String FORMATO_DE_FECHA_DE_ENTREGA_INCORRECTO = "Formato de fecha de entrega incorrecto";
    private static final String LA_FECHA_DE_ALQUILER_ES_INVALIDA = "La fecha de alquiler es invalida";
    private static final String LA_FECHA_DE_ENTREGA_ES_INVALIDA = "La fecha de entrega es invalida";
    private static final String LA_FECHA_DE_ALQUILER_DEBE_SER_MENOR_A_LA_FECHA_DE_ENTREGA = "La fecha de alquiler debe ser menor a la fecha de entrega";
    private static final String DEBE_INGRESAR_UN_ID_DE_CLIENTE = "Debe ingresar un identificador de cliente";
    private static final String DEBE_INGRESAR_UN_ID_DE_MOTO = "Debe ingresar un identificador de moto";
    private static final int LONGITUD_MINIMA_DATOS = 1;

    private Long id;
    private LocalDate fechaAlquiler;
    private LocalDate fechaEntrega;
    private Long idCliente;
    private Long idMoto;
    private double valorPago;

    public Alquiler(Long id, String fechaAlquiler, String fechaEntrega, Long idCliente, Long idMoto) {

        validarObligatorio(fechaAlquiler, SE_DEBE_INGRESAR_LA_FECHA_DE_ALQUILER);
        validarObligatorio(fechaEntrega, SE_DEBE_INGRESAR_LA_FECHA_DE_ENTREGA);
        validarObligatorio(idCliente, DEBE_INGRESAR_UN_ID_DE_CLIENTE);
        validarObligatorio(idMoto, DEBE_INGRESAR_UN_ID_DE_MOTO);

        validarLongitud(fechaAlquiler, LONGITUD_MINIMA_DATOS, SE_DEBE_INGRESAR_LA_FECHA_DE_ALQUILER);
        validarLongitud(fechaEntrega, LONGITUD_MINIMA_DATOS, SE_DEBE_INGRESAR_LA_FECHA_DE_ENTREGA);


        validarFormatoFecha(fechaAlquiler, FORMATO_DE_FECHA_DE_ALQUILER_INCORRECTO);
        validarFormatoFecha(fechaEntrega, FORMATO_DE_FECHA_DE_ENTREGA_INCORRECTO);

        validarFechaCorrecta(fechaAlquiler, LA_FECHA_DE_ALQUILER_ES_INVALIDA);
        validarFechaCorrecta(fechaEntrega, LA_FECHA_DE_ENTREGA_ES_INVALIDA);

        LocalDate fechaAlquilerFinal = obtenerLocalDateDesdeUnString(fechaAlquiler);
        LocalDate fechaEntregaFinal = obtenerLocalDateDesdeUnString(fechaEntrega);
        validarFechaMenor(fechaAlquilerFinal, fechaEntregaFinal, LA_FECHA_DE_ALQUILER_DEBE_SER_MENOR_A_LA_FECHA_DE_ENTREGA);

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

    public LocalDate obtenerLocalDateDesdeUnString(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        LocalDate fechaFinal = LocalDate.parse(fecha, formatter);
        return fechaFinal;
    }
}
