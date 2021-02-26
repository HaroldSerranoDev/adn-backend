package com.ceiba.alquiler.puerto.repositorio;


import com.ceiba.alquiler.modelo.entidad.Alquiler;

public interface RepositorioAlquiler {
    /**
     * Permite crear un alquiler
     * @param alquiler
     * @return el id generado
     */
    Long crear(Alquiler alquiler);

    /**
     * Permite actualizar un alquiler
     * @param alquiler
     */
    void actualizar(Alquiler alquiler);

    /**
     * Permite eliminar un alquiler
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un alquiler por id
     * @param id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
