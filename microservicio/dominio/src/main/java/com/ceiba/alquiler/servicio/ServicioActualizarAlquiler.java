package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.excepcion.AlquilerException;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.moto.puerto.dao.DaoMoto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;

public class ServicioActualizarAlquiler {

    private static final String EL_ALQUILER_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA = "El alquiler que intenta actualizar no existe en el sistema";
    private static final double AUMENTO_COSTO_ALQUILER = 0.15;

    private final RepositorioAlquiler repositorioAlquiler;
    private final RepositorioCliente repositorioCliente;
    private final RepositorioMoto repositorioMoto;
    private final DaoMoto daoMoto;
    private final ValidadorAlquiler validadorAlquiler;

    public ServicioActualizarAlquiler(RepositorioAlquiler repositorioAlquiler, RepositorioCliente repositorioCliente, RepositorioMoto repositorioMoto, DaoMoto daoMoto) {
        this.repositorioAlquiler = repositorioAlquiler;
        this.repositorioCliente = repositorioCliente;
        this.repositorioMoto = repositorioMoto;
        this.daoMoto = daoMoto;
        this.validadorAlquiler = new ValidadorAlquiler(this.repositorioAlquiler, this.repositorioCliente, this.repositorioMoto);
    }

    public void ejecutar(Alquiler alquiler) {
        validarExistenciaPreviaAlquiler(alquiler);
        validadorAlquiler.validarExistenciaPreviaCliente(alquiler.getIdCliente());
        validadorAlquiler.validarExistenciaMoto(alquiler.getIdMoto());
        validadorAlquiler.validarExistenciaAlquilerActualDeMoto(alquiler.getFechaEntrega(), alquiler.getIdMoto());
        validadorAlquiler.validarNumeroDiasAlquiler(alquiler.getFechaAlquiler(), alquiler.getFechaEntrega());
        validadorAlquiler.validarNumeroDiasAnticipacionSolicitudAlquiler(alquiler.getFechaAlquiler());

        double valorPago = 0;
        Double costoAlquilerMoto = daoMoto.obtenerCostoAlquiler(alquiler.getIdMoto());
        if (validadorAlquiler.validarExistenciaFinesSemanaAlquiler(alquiler.getFechaAlquiler(), alquiler.getFechaEntrega())) {
            valorPago = (costoAlquilerMoto * AUMENTO_COSTO_ALQUILER) + costoAlquilerMoto;
        } else {
            valorPago = costoAlquilerMoto;
        }
        alquiler.setValorPago(valorPago);


        this.repositorioAlquiler.actualizar(alquiler);
    }

    private void validarExistenciaPreviaAlquiler(Alquiler alquiler) {
        boolean existe = this.repositorioAlquiler.existePorId(alquiler.getId());
        if (!existe) {
            throw new AlquilerException(EL_ALQUILER_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
