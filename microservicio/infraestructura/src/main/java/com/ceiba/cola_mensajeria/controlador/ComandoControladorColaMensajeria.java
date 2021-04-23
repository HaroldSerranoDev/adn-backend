package com.ceiba.cola_mensajeria.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cola_mensajeria.comando.ComandoMensaje;
import com.ceiba.cola_mensajeria.comando.manejador.ManejadorEnviarMensaje;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cola-mensajeria")
@Api(tags = {"Controlador comando cola de mensajería"})
public class ComandoControladorColaMensajeria {

    private final ManejadorEnviarMensaje manejadorEnviarMensaje;

    @Autowired
    public ComandoControladorColaMensajeria(ManejadorEnviarMensaje manejadorEnviarMensaje) {
        this.manejadorEnviarMensaje = manejadorEnviarMensaje;
    }

    @PostMapping
    @ApiOperation("Enviar mensaje")
    public ComandoRespuesta<String> enviarMensaje(@RequestBody ComandoMensaje mensaje) {
        return manejadorEnviarMensaje.ejecutar(mensaje);
    }
}
