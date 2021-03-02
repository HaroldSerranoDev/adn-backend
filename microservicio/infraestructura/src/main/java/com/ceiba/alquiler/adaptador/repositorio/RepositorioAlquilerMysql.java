package com.ceiba.alquiler.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Repository
public class RepositorioAlquilerMysql implements RepositorioAlquiler {

    private static final String FORMATO_FECHA = "yyyy-MM-dd";

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="alquiler", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="alquiler", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="alquiler", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="alquiler", value="existePorId")
    private static String sqlExistePorId;

    @SqlStatement(namespace="alquiler", value="existeAlquilerPorFechasIdMoto")
    private static String sqlExistePorFechasIdMoto;


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
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }

    @Override
    public boolean existeAlquilerPorFechasParaMoto(LocalDate fechaAlquiler, Long idMoto) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        String fechaAlquilerFinal = fechaAlquiler.format(formatter);

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fechaAlquiler", fechaAlquilerFinal);
        paramSource.addValue("idMoto", idMoto);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorFechasIdMoto,paramSource, Boolean.class);
    }


    @Override
    public void actualizar(Alquiler alquiler) {
        this.customNamedParameterJdbcTemplate.actualizar(alquiler, sqlActualizar);
    }

}
