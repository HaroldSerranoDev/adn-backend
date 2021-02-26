package com.ceiba.moto.puerto.dao;

import com.ceiba.moto.modelo.dto.DtoMoto;

import java.util.List;

public interface DaoMoto {

    /**
     * Permite listar motos
     * @return listado de motos
     */
    List<DtoMoto> listar();

    /**
     * Permite buscar una moto por matricula
     * @return una moto
     */
    DtoMoto buscarPorMatricula(String matricula);

    /**
     * Permite buscar una moto por id
     * @return una moto
     */
    DtoMoto buscarPorId(Long id);
}
