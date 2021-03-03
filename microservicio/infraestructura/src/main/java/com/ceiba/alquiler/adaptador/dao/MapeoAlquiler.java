package com.ceiba.alquiler.adaptador.dao;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.moto.modelo.dto.DtoMoto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoAlquiler implements RowMapper<DtoAlquiler>, MapperResult {

    @Override
    public DtoAlquiler mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        LocalDate fechaAlquiler = extraerLocalDate(resultSet, "fecha_alquiler");
        LocalDate fechaEntrega = extraerLocalDate(resultSet, "fecha_entrega");
        double valorPago = resultSet.getDouble("valor_pago");

        Long idCliente = resultSet.getLong("id_cliente");
        String nombre = resultSet.getString("nombre");
        String direccion = resultSet.getString("direccion");
        String telefono = resultSet.getString("telefono");
        String cedula = resultSet.getString("cedula");
        String correo = resultSet.getString("correo");

        Long idMoto = resultSet.getLong("id_moto");
        String matricula = resultSet.getString("matricula");
        String marca = resultSet.getString("marca");
        int modelo = resultSet.getInt("modelo");
        String tipoMoto = resultSet.getString("tipo_moto");
        int kilometrosRecorridos = resultSet.getInt("kilometros_recorridos");
        double precioAlquiler = resultSet.getDouble("precio_alquiler");

        DtoCliente cliente = new DtoCliente(idCliente, nombre, direccion, telefono, cedula, correo);
        DtoMoto moto = new DtoMoto(idMoto, matricula, marca, modelo, tipoMoto, kilometrosRecorridos, precioAlquiler);

        return new DtoAlquiler(id, fechaAlquiler, fechaEntrega, cliente, moto, valorPago);
    }

}
