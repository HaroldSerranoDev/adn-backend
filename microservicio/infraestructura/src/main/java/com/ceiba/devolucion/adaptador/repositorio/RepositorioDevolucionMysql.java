package com.ceiba.devolucion.adaptador.repositorio;

import com.ceiba.devolucion.modelo.entidad.Devolucion;
import com.ceiba.devolucion.puerto.repositorio.RepositorioDevolucion;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDevolucionMysql implements RepositorioDevolucion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="devolucion", value="crear")
    private static String sqlCrear;


    public RepositorioDevolucionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Devolucion devolucion) {
        return this.customNamedParameterJdbcTemplate.crear(devolucion, sqlCrear);
    }

    @Override
    public boolean existe(Long idAlquiler) {
        return false;
    }

}
