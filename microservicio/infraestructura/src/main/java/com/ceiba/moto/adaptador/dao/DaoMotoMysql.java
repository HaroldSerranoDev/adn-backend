package com.ceiba.moto.adaptador.dao;

import com.ceiba.moto.modelo.dto.DtoMoto;
import com.ceiba.moto.puerto.dao.DaoMoto;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoMotoMysql implements DaoMoto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="moto", value="listar")
    private static String sqlListar;

    public DaoMotoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoMoto> listar() {
        return null;
    }

    @Override
    public DtoMoto buscarPorMatricula(String matricula) {
        return null;
    }

    @Override
    public DtoMoto buscarPorId(Long id) {
        return null;
    }
}
