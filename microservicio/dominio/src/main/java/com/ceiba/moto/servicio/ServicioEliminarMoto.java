package com.ceiba.moto.servicio;

import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;

public class ServicioEliminarMoto {

    private static final String LA_MOTO_QUE_INTENTA_ELIMINAR_NO_EXISTE_EN_EL_SISTEMA = "La moto que intenta eliminar no existe en el sistema";


    private final RepositorioMoto repositorioMoto;

    public ServicioEliminarMoto(RepositorioMoto repositorioMoto) {
        this.repositorioMoto = repositorioMoto;
    }

    public void ejecutar(Long id) {
        this.repositorioMoto.eliminar(id);
    }


    private void validarExistencia(Moto moto) {
        boolean existe = this.repositorioMoto.existePorId(moto.getId());
        if(!existe) {
            // lanzar error, objeto no existente
        }
    }
}
