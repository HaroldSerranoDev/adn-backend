package com.ceiba.cola_mensajeria.servicio;

import com.ceiba.cola_mensajeria.modelo.dto.DtoMensaje;
import com.ceiba.cola_mensajeria.puerto.obtener_mensajes.ObtenerMensajes;


public class ServicioObtenerMensaje {

    private final ObtenerMensajes obtenerMensajes;

    public ServicioObtenerMensaje (ObtenerMensajes obtenerMensajes) {
        this.obtenerMensajes = obtenerMensajes;
    }

    public DtoMensaje ejecutar(String nombreCola) {
        return obtenerMensajes.obtenerMensajeUnico(nombreCola);
    }

}
