package com.ceiba.alquiler.puerto.dao;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;

import java.util.List;

public interface DaoAlquiler {

    /**
     * Permite listar alquileres
     * @return listado de alquileres
     */
    List<DtoAlquiler> listar();

    /**
     * Permite buscar un alquiler por id de cliente y id de moto
     * @return una alquiler
     */
    DtoAlquiler buscarPorIdClienteIdMoto(Long idCliente,Long idMoto);

    /**
     * Permite buscar un alquiler por cédula de cliente y matricula de moto
     * @return una alquiler
     */
    DtoAlquiler buscarPorCedulaClienteYMatriculaMoto(Long idCliente,Long idMoto);

    /**
     * Permite buscar una alquiler por id
     * @return un alquiler
     */
    DtoAlquiler buscarPorId(Long id);
}
