package com.ceiba.cola_mensajeria.puerto.obtener_mensajes;

import com.ceiba.cola_mensajeria.modelo.dto.DtoMensaje;

public interface ObtenerMensajes {

    /**
     * Permite obtener un mensaje a una cola de mensajeria
     * @param nombreCola
     * @return
     */
    DtoMensaje obtenerMensajeUnico(String nombreCola);

}
