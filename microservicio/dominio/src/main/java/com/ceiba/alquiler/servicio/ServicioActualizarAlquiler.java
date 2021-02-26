package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.alquiler.modelo.entidad.Alquiler;

public class ServicioActualizarAlquiler {

    private static final String EL_ALQUILER_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA = "El alquiler que intenta actualizar no existe en el sistema";

    private final RepositorioAlquiler repositorioAlquiler;

    public ServicioActualizarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }

    public void ejecutar(Alquiler alquiler) {
        validarExistencia(alquiler);
        this.repositorioAlquiler.actualizar(alquiler);
    }

    private void validarExistencia(Alquiler alquiler) {
        boolean existe = this.repositorioAlquiler.existePorId(alquiler.getId());
        if(!existe) {
            // lanzar error, objeto no existente
        }
    }
}
