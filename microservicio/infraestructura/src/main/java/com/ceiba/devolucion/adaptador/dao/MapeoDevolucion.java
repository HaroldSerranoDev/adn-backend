package com.ceiba.devolucion.adaptador.dao;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.devolucion.modelo.dto.DtoDevolucion;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoDevolucion implements RowMapper<DtoDevolucion>, MapperResult {

    @Override
    public DtoDevolucion mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        LocalDate fechaDevolucion = extraerLocalDate(resultSet, "fecha_devolucion");
        Integer kilometrosFinales = resultSet.getInt("km_finales");
        Alquiler alquiler = resultSet.getObject("alquiler_id",Alquiler.class);
        return new DtoDevolucion(id,fechaDevolucion, kilometrosFinales,alquiler);
    }

}
