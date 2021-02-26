package com.ceiba.devolucion.puerto.repositorio;


import com.ceiba.devolucion.modelo.entidad.Devolucion;

public interface RepositorioDevolucion {
    /**
     * Permite crear una devolución
     * @param devolucion
     * @return el id generado
     */
    Long crear(Devolucion devolucion);

    /**
     * Permite validar si existe un devolución con un id de alquiler
     * @param idAlquiler
     * @return si existe o no
     */
    boolean existe(Long idAlquiler);
}
