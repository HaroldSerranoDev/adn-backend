package com.ceiba.devolucion.servicio;

import com.ceiba.devolucion.modelo.entidad.Devolucion;
import com.ceiba.devolucion.puerto.repositorio.RepositorioDevolucion;


public class ServicioCrearDevolucion {

    private final RepositorioDevolucion repositorioDevolucion;

    public ServicioCrearDevolucion(RepositorioDevolucion repositorioDevolucion) {
        this.repositorioDevolucion = repositorioDevolucion;
    }

    public Long ejecutar(Devolucion devolucion) {
        yaHayDevolucion(devolucion);
        return this.repositorioDevolucion.crear(devolucion);
    }

    private void yaHayDevolucion(Devolucion devolucion) {
    }
}
