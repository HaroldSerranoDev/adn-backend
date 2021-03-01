package com.ceiba.moto.servicio;

import com.ceiba.moto.excepcion.MotoException;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;

public class ServicioEliminarMoto {

    private static final String LA_MOTO_QUE_INTENTA_ELIMINAR_NO_EXISTE_EN_EL_SISTEMA = "La moto que intenta eliminar no existe en el sistema";


    private final RepositorioMoto repositorioMoto;

    public ServicioEliminarMoto(RepositorioMoto repositorioMoto) {
        this.repositorioMoto = repositorioMoto;
    }

    public void ejecutar(Long id) {
        validarExistenciaMoto(id);
        this.repositorioMoto.eliminar(id);
    }


    private void validarExistenciaMoto(Long id) {
        boolean existe = this.repositorioMoto.existePorId(id);
        if (!existe) {
            throw new MotoException(LA_MOTO_QUE_INTENTA_ELIMINAR_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
