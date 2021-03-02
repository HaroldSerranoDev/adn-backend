package com.ceiba.devolucion.consulta;

import com.ceiba.devolucion.modelo.dto.DtoDevolucion;
import com.ceiba.devolucion.puerto.dao.DaoDevolucion;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarDevoluciones {

    private final DaoDevolucion daoDevolucion;

    public ManejadorListarDevoluciones(DaoDevolucion daoDevolucion) {
        this.daoDevolucion = daoDevolucion;
    }

    public List<DtoDevolucion> ejecutar() {
        return this.daoDevolucion.listar();
    }
}
