package com.ceiba.cola_mensajeria.consulta;

import com.ceiba.cola_mensajeria.modelo.dto.DtoMensaje;
import com.ceiba.cola_mensajeria.servicio.ServicioObtenerMensaje;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerMensaje {

    private final ServicioObtenerMensaje servicioEnviarMensaje;

    public ManejadorObtenerMensaje(ServicioObtenerMensaje servicioEnviarMensaje) {
        this.servicioEnviarMensaje = servicioEnviarMensaje;

    }
    public DtoMensaje ejecutar(String nombreCola) {
        return servicioEnviarMensaje.ejecutar(nombreCola);
    }
}
