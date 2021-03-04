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
        validadorAlquiler.validarExistenciaAlquilerActualDeMoto(alquiler.getFechaAlquiler(), alquiler.getIdMoto(), alquiler.getId());
        validadorAlquiler.validarNumeroDiasAlquiler(alquiler.getFechaAlquiler(), alquiler.getFechaEntrega());
        validadorAlquiler.validarNumeroDiasAnticipacionSolicitudAlquiler(alquiler.getFechaAlquiler());

        double valorPagoCreacion = 0;
        Double costoAlquilerMotoCreacion = daoMoto.obtenerCostoAlquiler(alquiler.getIdMoto());

        if (validadorAlquiler.validarExistenciaFinesSemanaAlquiler(alquiler.getFechaAlquiler(), alquiler.getFechaEntrega())) {
            valorPagoCreacion = (costoAlquilerMotoCreacion * AUMENTO_COSTO_ALQUILER) + costoAlquilerMotoCreacion;
        } else {
            valorPagoCreacion = costoAlquilerMotoCreacion;
        }
        alquiler.setValorPago(valorPagoCreacion);

        return this.repositorioAlquiler.crear(alquiler);
    }


}
