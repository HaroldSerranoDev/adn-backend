package com.ceiba.alquiler.excepcion;

public class AlquilerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AlquilerException(String message) {
        super(message);
    }
}
