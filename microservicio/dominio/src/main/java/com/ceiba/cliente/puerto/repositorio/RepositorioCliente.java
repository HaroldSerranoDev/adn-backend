package com.ceiba.cliente.puerto.repositorio;


import com.ceiba.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {
    /**
     * Permite crear un cliente
     *
     * @param cliente
     * @return el id generado
     */
    Long crear(Cliente cliente);

    /**
     * Permite actualizar un cliente
     *
     * @param cliente
     */
    void actualizar(Cliente cliente);

    /**
     * Permite eliminar un cliente
     *
     * @param id
     */
    void eliminar(Long id);


    /**
     * Permite validar si existe un cliente con una cédula o con un correo
     *
     * @param cedula
     * @return si existe o no
     */
    boolean existePorCedulaOCorreoExcluyendoId(String cedula, String correo, Long id);

    /**
     * Permite validar si existe un cliente por un id
     *
     * @param id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
