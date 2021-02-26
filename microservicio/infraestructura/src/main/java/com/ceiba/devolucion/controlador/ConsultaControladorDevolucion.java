package com.ceiba.devolucion.controlador;

import com.ceiba.devolucion.consulta.ManejadorListarDevoluciones;
import com.ceiba.devolucion.modelo.dto.DtoDevolucion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/devoluciones")
@Api(tags={"Controlador consulta devolución"})
public class ConsultaControladorDevolucion {

    private final ManejadorListarDevoluciones manejadorListarDevoluciones;

    public ConsultaControladorDevolucion(ManejadorListarDevoluciones manejadorListarDevolucions) {
        this.manejadorListarDevoluciones = manejadorListarDevolucions;
    }

    @GetMapping
    @ApiOperation("Listar Devolucions")
    public List<DtoDevolucion> listar() {
        return this.manejadorListarDevoluciones.ejecutar();
    }

}
