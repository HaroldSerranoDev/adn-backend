package com.ceiba.cliente.servicio;

import com.ceiba.cliente.excepcion.ClienteException;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCliente {

    private static final String EL_CLIENTE_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA = "El cliente que intenta actualizar no existe en el sistema";
    private static final String EL_CORREO_O_LA_CEDULA_QUE_INTENTA_ASIGNAR_YA_EXISTE = "El correo o la cédula que intenta asignar, ya existe.";

    private final RepositorioCliente repositorioCliente;

    public ServicioActualizarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Cliente cliente) {
        validarExistenciaPreviaCliente(cliente);
        validarExistenciaDeCedulaOCorreo(cliente);
        this.repositorioCliente.actualizar(cliente);
    }

    public void validarExistenciaPreviaCliente(Cliente cliente) {
        boolean existe = this.repositorioCliente.existePorId(cliente.getId());
        if (!existe) {
            throw new ClienteException(EL_CLIENTE_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    public void validarExistenciaDeCedulaOCorreo(Cliente cliente) {
        boolean existe = repositorioCliente.existePorCedulaOCorreoExcluyendoId(cliente.getCedula(), cliente.getCorreo(), cliente.getId());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_CORREO_O_LA_CEDULA_QUE_INTENTA_ASIGNAR_YA_EXISTE);
        }
    }
}
