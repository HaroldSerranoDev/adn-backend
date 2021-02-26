package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
public class ServicioEliminarAlquiler {

    private static final String EL_ALQUILER_QUE_INTENTA_ELIMINAR_NO_EXISTE_EN_EL_SISTEMA = "El alquiler que intenta eliminar no existe en el sistema";


    private final RepositorioAlquiler repositorioAlquiler;

    public ServicioEliminarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        this.repositorioAlquiler = repositorioAlquiler;
    }

    public void ejecutar(Long id) {
        this.repositorioAlquiler.eliminar(id);
    }


    private void validarExistencia(Alquiler alquiler) {
        boolean existe = this.repositorioAlquiler.existePorId(alquiler.getId());
        if(!existe) {
            // lanzar error, objeto no existente
        }
    }
}
