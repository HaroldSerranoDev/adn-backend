package com.ceiba.devolucion.comando.fabrica;

import com.ceiba.devolucion.comando.ComandoDevolucion;
import com.ceiba.devolucion.modelo.entidad.Devolucion;
import org.springframework.stereotype.Component;

@Component
public class FabricaDevolucion {

    public Devolucion crear(ComandoDevolucion comandoDevolucion) {
        return new Devolucion(
                comandoDevolucion.getId(),
                comandoDevolucion.getFechaDevolucion(),
                comandoDevolucion.getKilometrosFinales(),
                comandoDevolucion.getAlquiler()
        );
    }

}
