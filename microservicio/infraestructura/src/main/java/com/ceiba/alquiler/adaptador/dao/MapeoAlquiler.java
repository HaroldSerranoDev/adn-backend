package com.ceiba.alquiler.adaptador.dao;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.moto.modelo.entidad.Moto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MapeoAlquiler implements RowMapper<DtoAlquiler>, MapperResult {

    @Override
    public DtoAlquiler mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        LocalDate fechaAlquiler = extraerLocalDate(resultSet, "fecha_alquiler");
        LocalDate fechaEntrega = extraerLocalDate(resultSet, "fecha_entrega");
        Cliente cliente= resultSet.getObject("cliente_id",Cliente.class);
        Moto moto= resultSet.getObject("moto_id", Moto.class);
        Double valorPago = resultSet.getDouble("valor_pago");

        return new DtoAlquiler(id,fechaAlquiler,fechaEntrega, cliente, moto, valorPago);
    }

}
