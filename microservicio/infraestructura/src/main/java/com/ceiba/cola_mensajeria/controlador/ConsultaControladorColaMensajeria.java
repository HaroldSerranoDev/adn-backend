package com.ceiba.cola_mensajeria.controlador;

import com.ceiba.cola_mensajeria.consulta.ManejadorObtenerMensaje;
import com.ceiba.cola_mensajeria.modelo.dto.DtoMensaje;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cola-mensajeria")
@Api(tags = {"Controlador consulta cola de mensajería"})
public class ConsultaControladorColaMensajeria {

    private final ManejadorObtenerMensaje manejadorObtenerMensaje;

    @Autowired
    public ConsultaControladorColaMensajeria(ManejadorObtenerMensaje manejadorObtenerMensaje) {
        this.manejadorObtenerMensaje = manejadorObtenerMensaje;
    }

    @GetMapping(value = "/{nombreCola}")
    @ApiOperation("Obtener mensaje")
    public DtoMensaje obtenerMensaje(@PathVariable String nombreCola) {
        return manejadorObtenerMensaje.ejecutar(nombreCola);
    }


}
