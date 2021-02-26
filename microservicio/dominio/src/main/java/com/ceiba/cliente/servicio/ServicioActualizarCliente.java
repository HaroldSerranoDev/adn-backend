package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;

public class ServicioActualizarCliente {

    private static final String EL_CLIENTE_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA = "El cliente que intenta actualizar no existe en el sistema";

    private final RepositorioCliente repositorioCliente;

    public ServicioActualizarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Cliente cliente) {
        validarExistencia(cliente);
        this.repositorioCliente.actualizar(cliente);
    }

    private void validarExistencia(Cliente cliente) {
        boolean existe = this.repositorioCliente.existePorId(cliente.getId());
        if(!existe) {
            // lanzar error, objeto no existente
        }
    }
}
