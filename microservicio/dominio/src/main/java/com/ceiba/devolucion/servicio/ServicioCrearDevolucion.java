package com.ceiba.devolucion.servicio;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.alquiler.puerto.dao.DaoAlquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.devolucion.excepcion.DevolucionException;
import com.ceiba.devolucion.modelo.entidad.Devolucion;
import com.ceiba.devolucion.puerto.repositorio.RepositorioDevolucion;
import com.ceiba.moto.modelo.dto.DtoMoto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;


public class ServicioCrearDevolucion {

    private static final String LA_DEVOLUCION_QUE_INTENTA_REALIZAR_YA_EXISTE = "La devolucion que intenta realizar ya existe";
    private static final String EL_ALQUILER_PARA_EL_CUAL_INTENTA_HACER_LA_DEVOLUCION_NO_EXISTE = "El alquiler par el cual intenta hacer la devolucón no existe";
    private static final int LIMITE_DE_KILOMETROS_RECORRIDOS = 400;
    private static final double AUMENTO_COSTO_ALQUILER = 0.1;


    private final RepositorioDevolucion repositorioDevolucion;
    private final RepositorioMoto repositorioMoto;
    private final RepositorioAlquiler repositorioAlquiler;
    private final DaoAlquiler daoAlquiler;

    public ServicioCrearDevolucion(RepositorioDevolucion repositorioDevolucion, RepositorioAlquiler repositorioAlquiler, RepositorioMoto repositorioMoto, DaoAlquiler daoAlquiler) {
        this.repositorioDevolucion = repositorioDevolucion;
        this.repositorioAlquiler = repositorioAlquiler;
        this.repositorioMoto = repositorioMoto;
        this.daoAlquiler = daoAlquiler;
    }

    public Long ejecutar(Devolucion devolucion) {
        validarExistenciaPreviaAlquiler(devolucion.getIdAlquiler());
        validarExistenciaPreviaDevolucionPorIdAlquiler(devolucion);

        DtoAlquiler dtoAlquiler = daoAlquiler.obtenerPorId(devolucion.getIdAlquiler());
        DtoMoto moto = dtoAlquiler.getMoto();
        int kilometrosMoto = moto.getKilometros_recorridos();
        int diferenciaKilomentros = devolucion.getKilometrosFinales() - kilometrosMoto;
        double costoAlquilerFinal = 0;

        if (diferenciaKilomentros > LIMITE_DE_KILOMETROS_RECORRIDOS) {
            costoAlquilerFinal = (dtoAlquiler.getValorPago() * AUMENTO_COSTO_ALQUILER) + dtoAlquiler.getValorPago();
        }else{
            costoAlquilerFinal = dtoAlquiler.getValorPago();
        }

        devolucion.setValorPagoFinal(costoAlquilerFinal);

        int totalKilometros = moto.getKilometros_recorridos() + diferenciaKilomentros;

        this.repositorioMoto.actualizarKilometrosMotoPorId(totalKilometros, moto.getId());

        return this.repositorioDevolucion.crear(devolucion);
    }

    public void validarExistenciaPreviaAlquiler(Long id) {
        boolean existe = this.repositorioAlquiler.existePorId(id);
        if (!existe) {
            throw new DevolucionException(EL_ALQUILER_PARA_EL_CUAL_INTENTA_HACER_LA_DEVOLUCION_NO_EXISTE);
        }
    }

    public void validarExistenciaPreviaDevolucionPorIdAlquiler(Devolucion devolucion) {
        boolean existe = this.repositorioDevolucion.existePorIdAlquiler(devolucion.getIdAlquiler());
        if (existe) {
            throw new DevolucionException(LA_DEVOLUCION_QUE_INTENTA_REALIZAR_YA_EXISTE);
        }
    }

}
