package com.ceiba.cola_mensajeria.servicio;

import com.ceiba.cola_mensajeria.puerto.envio_mensaje.EnvioMensaje;


public class ServicioEnviarMensaje {


    private final EnvioMensaje envioMensaje;
    private final String NOMBRE_COLA="adn";

    public ServicioEnviarMensaje(EnvioMensaje envioMensaje) {
        this.envioMensaje = envioMensaje;
    }

    public void ejecutar(String mensaje) {
       envioMensaje.enviarMensaje(NOMBRE_COLA,mensaje);
    }

}
