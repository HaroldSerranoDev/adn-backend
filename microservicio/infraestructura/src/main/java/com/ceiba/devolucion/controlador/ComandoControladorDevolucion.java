package com.ceiba.devolucion.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.devolucion.comando.ComandoDevolucion;
import com.ceiba.devolucion.comando.manejador.ManejadorCrearDevolucion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devoluciones")
@Api(tags = {"Controlador comando devolucion"})
public class ComandoControladorDevolucion {

    private final ManejadorCrearDevolucion manejadorCrearDevolucion;

    @Autowired
    public ComandoControladorDevolucion(ManejadorCrearDevolucion manejadorCrearDevolucion) {
        this.manejadorCrearDevolucion = manejadorCrearDevolucion;
    }

    @PostMapping
    @ApiOperation("Crear Devolucion")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoDevolucion comandoDevolucion) {
        return manejadorCrearDevolucion.ejecutar(comandoDevolucion);
    }
}
