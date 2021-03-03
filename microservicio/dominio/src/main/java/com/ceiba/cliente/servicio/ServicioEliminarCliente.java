package com.ceiba.cliente.servicio;

import com.ceiba.cliente.excepcion.ClienteException;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;

public class ServicioEliminarCliente {

    private static final String EL_CLIENTE_QUE_INTENTA_ELIMINAR_NO_EXISTE_EN_EL_SISTEMA = "El cliente que intenta eliminar no existe en el sistema";


    private final RepositorioCliente repositorioCliente;

    public ServicioEliminarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Long id) {
        validarExistenciaPreviaCliente(id);
        this.repositorioCliente.eliminar(id);
    }


    private void validarExistenciaPreviaCliente(Long id) {
        boolean existe = this.repositorioCliente.existePorId(id);
        if (!existe) {
            throw new ClienteException(EL_CLIENTE_QUE_INTENTA_ELIMINAR_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
