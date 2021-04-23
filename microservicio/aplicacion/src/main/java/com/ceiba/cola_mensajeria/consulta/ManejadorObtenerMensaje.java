package com.ceiba.cola_mensajeria.consulta;

import com.ceiba.cola_mensajeria.modelo.dto.DtoMensaje;
import com.ceiba.cola_mensajeria.puerto.obtener_mensajes.ObtenerMensajes;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerMensaje {

    private final ObtenerMensajes obtenerMensajes;

    public ManejadorObtenerMensaje(ObtenerMensajes obtenerMensajes) {
        this.obtenerMensajes = obtenerMensajes;

    }

    public DtoMensaje ejecutar(String nombreCola) {
        return obtenerMensajes.obtenerMensajeUnico(nombreCola);
    }
}
