package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.excepcion.AlquilerException;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class ValidadorAlquiler {

    private static final String EL_CLIENTE_QUE_INTENTA_REALIZAR_EL_ALQUILER_NO_EXISTE_EN_EL_SISTEMA = "El cliente que realizar el alquiler no existe en el sistema";
    private static final String LA_MOTO_QUE_INTENTA_ALQUILAR_NO_EXISTE_EN_EL_SISTEMA = "La moto que intenta alquilar no existe en el sistema";
    private static final String LA_MOTO_QUE_INTENTA_ALQUILAR_SE_ENCUENTRA_OCUPADA = "La moto que intenta alquilar se encuentra ocupada.";
    private static final String LIMITE_DE_DIAS_ALQUILER_SUPERADO = "Limite de dias de alquiler superado.";
    private static final String DEBE_SOLICITAR_SU_ALQUILER_CON_MINIMO_DOS_DIAS_DE_ANTICIPACION = "Debe solicitar su alquiler con mínimo dos días de anticipación.";
    private static final int LIMITE_DIAS_DE_ALQUILER = 5;
    private static final int LIMITE_INFERIOR_DIAS_SOLICITUD_ALQUILER = 2;
    private static final int SABADO = 6;
    private static final int DOMINGO = 7;
    private static final int NUMERO_DIAS_AUMENTAR = 1;


    private final RepositorioAlquiler repositorioAlquiler;
    private final RepositorioCliente repositorioCliente;
    private final RepositorioMoto repositorioMoto;

    public ValidadorAlquiler(RepositorioAlquiler repositorioAlquiler, RepositorioCliente repositorioCliente, RepositorioMoto repositorioMoto) {
        this.repositorioAlquiler = repositorioAlquiler;
        this.repositorioCliente = repositorioCliente;
        this.repositorioMoto = repositorioMoto;
    }

    public void validarExistenciaPreviaCliente(Long id) {
        boolean existe = this.repositorioCliente.existePorId(id);
        if (!existe) {
            throw new AlquilerException(EL_CLIENTE_QUE_INTENTA_REALIZAR_EL_ALQUILER_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    public void validarExistenciaMoto(Long id) {
        boolean existe = this.repositorioMoto.existePorId(id);
        if (!existe) {
            throw new AlquilerException(LA_MOTO_QUE_INTENTA_ALQUILAR_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    public void validarExistenciaAlquilerActualDeMoto(LocalDate fechaAlquiler, Long idMoto) {
        boolean existe = this.repositorioAlquiler.existeAlquilerPorFechasParaMoto(fechaAlquiler, idMoto);
        if (existe) {
            throw new AlquilerException(LA_MOTO_QUE_INTENTA_ALQUILAR_SE_ENCUENTRA_OCUPADA);
        }
    }

    public void validarNumeroDiasAlquiler(LocalDate fechaAlquiler, LocalDate fechaEntrega) {

        Long numeroDias = DAYS.between(fechaAlquiler, fechaEntrega);
        if (numeroDias > LIMITE_DIAS_DE_ALQUILER) {
            throw new AlquilerException(LIMITE_DE_DIAS_ALQUILER_SUPERADO);
        }
    }

    public void validarNumeroDiasAnticipacionSolicitudAlquiler(LocalDate fechaAlquiler) {
        LocalDate fechaActual = LocalDate.now();
        Long numeroDias = DAYS.between(fechaActual, fechaAlquiler);

        if (numeroDias < LIMITE_INFERIOR_DIAS_SOLICITUD_ALQUILER) {
            throw new AlquilerException(DEBE_SOLICITAR_SU_ALQUILER_CON_MINIMO_DOS_DIAS_DE_ANTICIPACION);
        }
    }

    public boolean validarExistenciaFinesSemanaAlquiler(LocalDate fechaAlquiler, LocalDate fechaEntrega) {
        Long numeroDias = DAYS.between(fechaAlquiler, fechaEntrega);
        for (int dia = 0; dia < numeroDias; dia++) {

            if (fechaAlquiler.getDayOfWeek().getValue() == SABADO || fechaAlquiler.getDayOfWeek().getValue() == DOMINGO) {
                return true;
            }
            fechaAlquiler = fechaAlquiler.plusDays(NUMERO_DIAS_AUMENTAR);
        }

        return false;
    }
}
