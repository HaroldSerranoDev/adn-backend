package com.ceiba.moto.consulta;

import com.ceiba.moto.modelo.dto.DtoMoto;
import com.ceiba.moto.puerto.dao.DaoMoto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarMotos {

    private final DaoMoto daoMoto;

    public ManejadorListarMotos(DaoMoto daoMoto) {
        this.daoMoto = daoMoto;
    }

    public List<DtoMoto> ejecutar() {
        return this.daoMoto.listar();
    }
}
