package com.ceiba.moto.puerto.repositorio;


import com.ceiba.moto.modelo.entidad.Moto;

public interface RepositorioMoto {
    /**
     * Permite crear una moto
     * @param moto
     * @return el id generado
     */
    Long crear(Moto moto);

    /**
     * Permite actualizar una moto
     * @param moto
     */
    void actualizar(Moto moto);


    /**
     * Permite eliminar una moto
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una moto con una matricula excluyendo el Id
     * @param matricula
     * @return si existe o no
     */
    boolean existePorMatriculaExcluyendoId(String matricula, Long id);

    /**
     * Permite validar si existe una moto por un id
     * @param id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
