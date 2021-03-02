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
     * Permite obtener el costo del alquiler de una moto por id
     * @return una moto
     */
    Double obtenerCostoAlquiler(Long id);
}
