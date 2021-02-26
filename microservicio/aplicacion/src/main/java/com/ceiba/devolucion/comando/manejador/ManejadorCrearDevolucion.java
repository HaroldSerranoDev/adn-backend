package com.ceiba.devolucion.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.devolucion.comando.ComandoDevolucion;
import com.ceiba.devolucion.comando.fabrica.FabricaDevolucion;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.devolucion.modelo.entidad.Devolucion;
import com.ceiba.devolucion.servicio.ServicioCrearDevolucion;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearDevolucion implements ManejadorComandoRespuesta<ComandoDevolucion, ComandoRespuesta<Long>> {

    private final FabricaDevolucion fabricaDevolucion;
    private final ServicioCrearDevolucion servicioCrearDevolucion;

    public ManejadorCrearDevolucion(FabricaDevolucion fabricaDevolucion, ServicioCrearDevolucion servicioCrearDevolucion) {
        this.fabricaDevolucion = fabricaDevolucion;
        this.servicioCrearDevolucion = servicioCrearDevolucion;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoDevolucion comandoDevolucion) {
        Devolucion devolucion = this.fabricaDevolucion.crear(comandoDevolucion);
        return new ComandoRespuesta<>(this.servicioCrearDevolucion.ejecutar(devolucion));
    }
}
