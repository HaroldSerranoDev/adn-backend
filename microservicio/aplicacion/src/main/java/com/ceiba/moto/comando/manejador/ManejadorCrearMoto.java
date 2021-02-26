package com.ceiba.moto.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.moto.comando.ComandoMoto;
import com.ceiba.moto.comando.fabrica.FabricaMoto;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.servicio.ServicioCrearMoto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearMoto implements ManejadorComandoRespuesta<ComandoMoto, ComandoRespuesta<Long>> {

    private final FabricaMoto fabricaMoto;
    private final ServicioCrearMoto servicioCrearMoto;

    public ManejadorCrearMoto(FabricaMoto fabricaMoto, ServicioCrearMoto servicioCrearMoto) {
        this.fabricaMoto = fabricaMoto;
        this.servicioCrearMoto = servicioCrearMoto;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoMoto comandoMoto) {
        Moto moto = this.fabricaMoto.crear(comandoMoto);
        return new ComandoRespuesta<>(this.servicioCrearMoto.ejecutar(moto));
    }
}
