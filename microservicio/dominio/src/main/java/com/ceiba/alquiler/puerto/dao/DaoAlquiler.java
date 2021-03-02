package com.ceiba.alquiler.puerto.dao;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;

import java.util.List;

public interface DaoAlquiler {

    /**
     * Permite listar alquileres
     *
     * @return listado de alquileres
     */
    List<DtoAlquiler> listar();

    /**
     * Permite obtener un alquiler por id
     *
     * @return listado de alquileres
     */
    DtoAlquiler obtenerPorId(Long id);

}
