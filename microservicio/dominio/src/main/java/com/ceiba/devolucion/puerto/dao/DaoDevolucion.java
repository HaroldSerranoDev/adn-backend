package com.ceiba.devolucion.puerto.dao;

import com.ceiba.devolucion.modelo.dto.DtoDevolucion;

import java.util.List;

public interface DaoDevolucion {
    /**
     * Permite listar devoluciones
     *
     * @return listado de devoluciones
     */
    List<DtoDevolucion> listar();
}
