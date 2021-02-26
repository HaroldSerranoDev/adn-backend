package com.ceiba.moto.servicio;

import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;


public class ServicioCrearMoto {

    private final RepositorioMoto repositorioMoto;

    public ServicioCrearMoto(RepositorioMoto repositorioMoto) {
        this.repositorioMoto = repositorioMoto;
    }

    public Long ejecutar(Moto moto) {
        yaHayMoto(moto);
        return this.repositorioMoto.crear(moto);
    }

    private void yaHayMoto(Moto moto) {
    }
}
