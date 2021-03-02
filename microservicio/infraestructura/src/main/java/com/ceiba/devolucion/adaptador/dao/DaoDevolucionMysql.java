package com.ceiba.devolucion.adaptador.dao;

import com.ceiba.devolucion.modelo.dto.DtoDevolucion;
import com.ceiba.devolucion.puerto.dao.DaoDevolucion;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoDevolucionMysql implements DaoDevolucion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "devolucion", value = "listar")
    private static String sqlListar;

    public DaoDevolucionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoDevolucion> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoDevolucion());
    }
}
