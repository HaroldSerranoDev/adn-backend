package com.ceiba.alquiler.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.comando.manejador.ManejadorActualizarAlquiler;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearAlquiler;
import com.ceiba.alquiler.comando.manejador.ManejadorEliminarAlquiler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alquileres")
@Api(tags = { "Controlador comando alquiler"})
public class ComandoControladorAlquiler {

    private final ManejadorCrearAlquiler manejadorCrearAlquiler;
	private final ManejadorEliminarAlquiler manejadorEliminarAlquiler;
	private final ManejadorActualizarAlquiler manejadorActualizarAlquiler;

    @Autowired
    public ComandoControladorAlquiler(ManejadorCrearAlquiler manejadorCrearAlquiler,
									  ManejadorEliminarAlquiler manejadorEliminarAlquiler,
									  ManejadorActualizarAlquiler manejadorActualizarAlquiler) {
        this.manejadorCrearAlquiler = manejadorCrearAlquiler;
		this.manejadorEliminarAlquiler = manejadorEliminarAlquiler;
		this.manejadorActualizarAlquiler = manejadorActualizarAlquiler;
    }

    @PostMapping
    @ApiOperation("Crear Alquiler")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAlquiler comandoAlquiler) {
        return manejadorCrearAlquiler.ejecutar(comandoAlquiler);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Alquiler")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarAlquiler.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Alquiler")
	public void actualizar(@RequestBody ComandoAlquiler comandoAlquiler,@PathVariable Long id) {
		comandoAlquiler.setId(id);
		manejadorActualizarAlquiler.ejecutar(comandoAlquiler);
	}
}
