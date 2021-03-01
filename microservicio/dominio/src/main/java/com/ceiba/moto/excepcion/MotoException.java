package com.ceiba.moto.excepcion;

public class MotoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MotoException(String message) {
        super(message);
    }
}
