package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;

import java.util.List;

public interface DaoCliente {

    /**
     * Permite listar clientes
     * @return listado de clientes
     */
    List<DtoCliente> listar();

    /**
     * Permite buscar un cliente por cédula
     * @return un cliente
     */
    DtoCliente buscarPorCedula(String cedula);

    /**
     * Permite buscar un cliente por id
     * @return un cliente
     */
    DtoCliente buscarPorId(Long id);
}
