package com.ceiba.devolucion.puerto.dao;

import com.ceiba.devolucion.modelo.dto.DtoDevolucion;

import java.util.List;

public interface DaoDevolucion {
    /**
     * Permite listar devoluciones
     * @return listado de devoluciones
     */
    List<DtoDevolucion> listar();

    /**
     * Permite buscar una devolución por id de alquiler
     * @return una devolución
     */
    DtoDevolucion buscarPorIdAlquiler(Long idAlquiler);

    /**
     * Permite buscar una devolución por id
     * @return una devolución
     */
    DtoDevolucion buscarPorId(Long id);
}
