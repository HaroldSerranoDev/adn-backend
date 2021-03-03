package com.ceiba.moto.servicio;

import com.ceiba.moto.excepcion.MotoException;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;

public class ServicioActualizarMoto {

    private static final String LA_MOTO_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA = "La moto que intenta actualizar no existe en el sistema";

    private final RepositorioMoto repositorioMoto;

    public ServicioActualizarMoto(RepositorioMoto repositorioMoto) {
        this.repositorioMoto = repositorioMoto;
    }

    public void ejecutar(Moto moto) {
        validarExistencia(moto);
        this.repositorioMoto.actualizar(moto);
    }

    private void validarExistencia(Moto moto) {
        boolean existe = this.repositorioMoto.existePorId(moto.getId());
        if (!existe) {
            throw new MotoException(LA_MOTO_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
