package com.ceiba.moto.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.moto.comando.ComandoMoto;
import com.ceiba.moto.comando.fabrica.FabricaMoto;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.servicio.ServicioActualizarMoto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarMoto implements ManejadorComando<ComandoMoto> {

    private final FabricaMoto fabricaMoto;
    private final ServicioActualizarMoto servicioActualizarMoto;

    public ManejadorActualizarMoto(FabricaMoto fabricaMoto, ServicioActualizarMoto servicioActualizarMoto) {
        this.fabricaMoto = fabricaMoto;
        this.servicioActualizarMoto = servicioActualizarMoto;
    }

    public void ejecutar(ComandoMoto comandoMoto) {
        Moto moto = this.fabricaMoto.crear(comandoMoto);
        this.servicioActualizarMoto.ejecutar(moto);
    }
}
