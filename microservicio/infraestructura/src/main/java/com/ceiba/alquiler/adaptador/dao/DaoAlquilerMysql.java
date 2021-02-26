package com.ceiba.alquiler.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.alquiler.puerto.dao.DaoAlquiler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoAlquilerMysql implements DaoAlquiler {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="alquiler", value="listar")
    private static String sqlListar;

    public DaoAlquilerMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoAlquiler> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoAlquiler());
    }

    @Override
    public DtoAlquiler buscarPorIdClienteIdMoto(Long idCliente, Long idMoto) {
        return null;
    }

    @Override
    public DtoAlquiler buscarPorCedulaClienteYMatriculaMoto(Long idCliente, Long idMoto) {
        return null;
    }

    @Override
    public DtoAlquiler buscarPorId(Long id) {
        return null;
    }
}
