package com.ceiba.cliente.servicio;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;

public class ServicioEliminarCliente {

    private static final String EL_CLIENTE_QUE_INTENTA_ELIMINAR_NO_EXISTE_EN_EL_SISTEMA = "El cliente que intenta eliminar no existe en el sistema";


    private final RepositorioCliente repositorioCliente;

    public ServicioEliminarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Long id) {
        validarExistencia(id);
        this.repositorioCliente.eliminar(id);
    }


    private void validarExistencia(Long idCliente) {
        boolean existe = this.repositorioCliente.existePorId(idCliente);
        if(!existe) {
            // lanzar error, objeto no existente
        }
    }
}
