package com.ceiba.moto.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.moto.servicio.ServicioEliminarMoto;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarMoto implements ManejadorComando<Long> {

    private final ServicioEliminarMoto servicioEliminarMoto;

    public ManejadorEliminarMoto(ServicioEliminarMoto servicioEliminarMoto) {
        this.servicioEliminarMoto = servicioEliminarMoto;
    }

    public void ejecutar(Long idMoto) {
        this.servicioEliminarMoto.ejecutar(idMoto);
    }
}
