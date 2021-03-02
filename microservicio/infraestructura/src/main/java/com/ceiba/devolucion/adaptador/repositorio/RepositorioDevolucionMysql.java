package com.ceiba.devolucion.adaptador.repositorio;

import com.ceiba.devolucion.modelo.entidad.Devolucion;
import com.ceiba.devolucion.puerto.repositorio.RepositorioDevolucion;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDevolucionMysql implements RepositorioDevolucion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "devolucion", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "devolucion", value = "existePorIdAlquiler")
    private static String sqlExistePorIdAlquiler;


    public RepositorioDevolucionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Devolucion devolucion) {
        return this.customNamedParameterJdbcTemplate.crear(devolucion, sqlCrear);
    }

    @Override
    public boolean existePorIdAlquiler(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idAlquiler", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdAlquiler, paramSource, Boolean.class);
    }

}
