package com.ceiba.moto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.moto.comando.ComandoMoto;
import com.ceiba.moto.comando.manejador.ManejadorActualizarMoto;
import com.ceiba.moto.comando.manejador.ManejadorCrearMoto;
import com.ceiba.moto.comando.manejador.ManejadorEliminarMoto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/motoes")
@Api(tags = { "Controlador comando moto"})
public class ComandoControladorMoto {

    private final ManejadorCrearMoto manejadorCrearMoto;
	private final ManejadorEliminarMoto manejadorEliminarMoto;
	private final ManejadorActualizarMoto manejadorActualizarMoto;

    @Autowired
    public ComandoControladorMoto(ManejadorCrearMoto manejadorCrearMoto,
                                  ManejadorEliminarMoto manejadorEliminarMoto,
                                  ManejadorActualizarMoto manejadorActualizarMoto) {
        this.manejadorCrearMoto = manejadorCrearMoto;
		this.manejadorEliminarMoto = manejadorEliminarMoto;
		this.manejadorActualizarMoto = manejadorActualizarMoto;
    }

    @PostMapping
    @ApiOperation("Crear Moto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoMoto comandoMoto) {
        return manejadorCrearMoto.ejecutar(comandoMoto);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Moto")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarMoto.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Moto")
	public void actualizar(@RequestBody ComandoMoto comandoMoto,@PathVariable Long id) {
		comandoMoto.setId(id);
		manejadorActualizarMoto.ejecutar(comandoMoto);
	}
}
