package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.moto.puerto.dao.DaoMoto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;


public class ServicioCrearAlquiler {


    private static final double AUMENTO_COSTO_ALQUILER = 0.15;


    private final RepositorioAlquiler repositorioAlquiler;
    private final RepositorioCliente repositorioCliente;
    private final RepositorioMoto repositorioMoto;
    private final DaoMoto daoMoto;
    private final ValidadorAlquiler validadorAlquiler;

    public ServicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler, RepositorioCliente repositorioCliente, RepositorioMoto repositorioMoto, DaoMoto daoMoto) {
        this.repositorioAlquiler = repositorioAlquiler;
        this.repositorioCliente = repositorioCliente;
        this.repositorioMoto = repositorioMoto;
        this.daoMoto = daoMoto;
        this.validadorAlquiler = new ValidadorAlquiler(this.repositorioAlquiler, this.repositorioCliente, this.repositorioMoto);
    }

    public Long ejecutar(Alquiler alquiler) {
        validadorAlquiler.validarExistenciaPreviaCliente(alquiler.getIdCliente());
        validadorAlquiler.validarExistenciaMoto(alquiler.getIdMoto());
        validadorAlquiler.validarExistenciaAlquilerActualDeMoto(alquiler.getFechaAlquiler(), alquiler.getIdMoto());
        validadorAlquiler.validarNumeroDiasAlquiler(alquiler.getFechaAlquiler(), alquiler.getFechaEntrega());
        validadorAlquiler.validarNumeroDiasAnticipacionSolicitudAlquiler(alquiler.getFechaAlquiler());

        if (validadorAlquiler.validarExistenciaFinesSemanaAlquiler(alquiler.getFechaAlquiler(), alquiler.getFechaEntrega())) {
            Double costoAlquilerMoto = daoMoto.obtenerCostoAlquiler(alquiler.getIdMoto());
            double valorPago = (costoAlquilerMoto * AUMENTO_COSTO_ALQUILER) + costoAlquilerMoto;
            alquiler.setValorPago(valorPago);
        }

        return this.repositorioAlquiler.crear(alquiler);
    }


}
