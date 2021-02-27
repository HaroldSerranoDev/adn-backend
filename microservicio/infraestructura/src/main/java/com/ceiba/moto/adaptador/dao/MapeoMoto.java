package com.ceiba.moto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.moto.modelo.dto.DtoMoto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoMoto implements RowMapper<DtoMoto>, MapperResult {

    @Override
    public DtoMoto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String matricula = resultSet.getString("matricula");
        String marca= resultSet.getString("marca");
        int modelo= resultSet.getInt("modelo");
        String tipoMoto = resultSet.getString("tipo_moto");
        int kilometrosRecorridos = resultSet.getInt("kilometros_recorridos");
        double precioAlquiler = resultSet.getDouble("precio_alquiler");

        return new DtoMoto(id,matricula,marca,modelo,tipoMoto,kilometrosRecorridos,precioAlquiler);
    }

}
