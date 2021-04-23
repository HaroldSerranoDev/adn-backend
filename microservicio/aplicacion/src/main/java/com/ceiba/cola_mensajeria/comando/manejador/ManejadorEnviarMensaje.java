package com.ceiba.cola_mensajeria.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cola_mensajeria.comando.ComandoMensaje;
import com.ceiba.cola_mensajeria.servicio.ServicioEnviarMensaje;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEnviarMensaje implements ManejadorComandoRespuesta<ComandoMensaje, ComandoRespuesta<String>> {

    private final ServicioEnviarMensaje servicioEnviarMensaje;

    public ManejadorEnviarMensaje(ServicioEnviarMensaje servicioEnviarMensaje) {
        this.servicioEnviarMensaje = servicioEnviarMensaje;
    }

    public ComandoRespuesta<String> ejecutar(ComandoMensaje comandoMensaje) {
        servicioEnviarMensaje.ejecutar(comandoMensaje.getMensaje());
        return new ComandoRespuesta<>("El mensaje se ha envíado con éxito");
    }
}
