package com.ceiba.moto.adaptador.dao;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.moto.modelo.dto.DtoMoto;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.moto.modelo.entidad.Marca;
import com.ceiba.moto.modelo.entidad.TipoMoto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoMoto implements RowMapper<DtoMoto>, MapperResult {

    @Override
    public DtoMoto mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String matricula = resultSet.getString("matricula");
        Marca marca= Marca.valueOf(resultSet.getString("marca"));
        Integer modelo= resultSet.getInt("modelo");
        TipoMoto tipoMoto = TipoMoto.valueOf(resultSet.getString("tipo_moto"));
        Integer kilometrosRecorridos = resultSet.getInt("kilometros_recorridos");
        Double precioAlquiler = resultSet.getDouble("precio_alquiler");

        return new DtoMoto(id,matricula,marca,modelo,tipoMoto,kilometrosRecorridos,precioAlquiler);
    }

}
