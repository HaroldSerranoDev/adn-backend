package com.ceiba.cliente.excepcion;

public class ClienteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ClienteException(String message) {
        super(message);
    }
}
