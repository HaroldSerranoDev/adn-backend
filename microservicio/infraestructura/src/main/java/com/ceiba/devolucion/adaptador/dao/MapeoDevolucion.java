package com.ceiba.devolucion.adaptador.dao;

import com.ceiba.alquiler.modelo.dto.DtoAlquiler;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.devolucion.modelo.dto.DtoDevolucion;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.moto.modelo.dto.DtoMoto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoDevolucion implements RowMapper<DtoDevolucion>, MapperResult {

    @Override
    public DtoDevolucion mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        //DtoDevolucion
        Long id = resultSet.getLong("id_devolucion");
        LocalDate fechaDevolucion = extraerLocalDate(resultSet, "fecha_devolucion");
        int kilometrosFinales = resultSet.getInt("km_finales");


        //DtoCliente
        Long idCliente = resultSet.getLong("id_cliente");
        String nombre = resultSet.getString("nombre");
        String direccion = resultSet.getString("direccion");
        String telefono = resultSet.getString("telefono");
        String cedula = resultSet.getString("cedula");
        String correo = resultSet.getString("correo");

        //DtoMoto
        Long idMoto = resultSet.getLong("id_moto");
        String matricula = resultSet.getString("matricula");
        String marca = resultSet.getString("marca");
        int modelo = resultSet.getInt("modelo");
        String tipoMoto = resultSet.getString("tipo_moto");
        int kilometrosRecorridos = resultSet.getInt("kilometros_recorridos");
        double precioAlquiler = resultSet.getDouble("precio_alquiler");


        //DtoAlquiler
        Long idAlquiler = resultSet.getLong("id_alquiler");
        LocalDate fechaAlquiler = extraerLocalDate(resultSet,"fecha_alquiler");
        LocalDate fechaEntrega = extraerLocalDate(resultSet,"fecha_entrega");
        double valorPago = resultSet.getDouble("valor_pago");

        DtoCliente cliente = new DtoCliente(idCliente,nombre,direccion,telefono,cedula,correo);
        DtoMoto moto= new DtoMoto(idMoto,matricula,marca,modelo,tipoMoto,kilometrosRecorridos,precioAlquiler);
        DtoAlquiler alquiler = new DtoAlquiler(idAlquiler,fechaAlquiler,fechaEntrega,cliente,moto,valorPago);

        return new DtoDevolucion(id,fechaDevolucion, kilometrosFinales,alquiler);
    }

}
