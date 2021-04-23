package com.ceiba.cola_mensajeria.puerto.envio_mensaje;

public interface EnvioMensaje {

    /**
     * Permite enviar un mensaje a una cola de mensajeria
     *
     * @param nombreCola
     * @param mensaje
     */
    void enviarMensaje(String nombreCola, String mensaje);

}
