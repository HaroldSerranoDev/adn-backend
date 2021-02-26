package com.ceiba.alquiler.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;


public class ServicioCrearAlquiler {

    private final RepositorioAlquiler repositorioAlquiler;

    public ServicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }

    public Long ejecutar(Alquiler alquiler) {
        yaHayAlquiler(alquiler);
        return this.repositorioAlquiler.crear(alquiler);
    }

    private void yaHayAlquiler(Alquiler alquiler) {
    }
}
