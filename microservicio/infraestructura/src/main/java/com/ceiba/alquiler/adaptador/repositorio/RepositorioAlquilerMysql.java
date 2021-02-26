package com.ceiba.alquiler.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAlquilerMysql implements RepositorioAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="alquiler", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="alquiler", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="alquiler", value="eliminar")
    private static String sqlEliminar;


    public RepositorioAlquilerMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Alquiler alquiler) {
        return this.customNamedParameterJdbcTemplate.crear(alquiler, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existePorId(Long id) {
        return false;
    }


    @Override
    public void actualizar(Alquiler alquiler) {
        this.customNamedParameterJdbcTemplate.actualizar(alquiler, sqlActualizar);
    }

}
