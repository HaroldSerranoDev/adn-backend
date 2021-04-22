package com.ceiba.cola_mensajeria;

import com.ceiba.Mensaje.comando.ComandoMensaje;
import com.ceiba.configuracion.ClienteColaMensajeriaAzure;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.queue.CloudQueue;
import com.microsoft.azure.storage.queue.CloudQueueClient;
import com.microsoft.azure.storage.queue.CloudQueueMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

@RestController
@RequestMapping("/cola-mensajeria")
@Api(tags = {"Controlador comando cola de mensajería"})
public class ComandoControladorColaMensajeria {

    private final CloudQueueClient clienteColaMensajeriaAzure;

    @Autowired
    public ComandoControladorColaMensajeria(ClienteColaMensajeriaAzure clienteColaMensajeriaAzure) throws URISyntaxException, InvalidKeyException {
        this.clienteColaMensajeriaAzure = clienteColaMensajeriaAzure.clienteColaMensajería();
    }


    @GetMapping()
    @ApiOperation("Obtener mensaje")
    public String obtenerMensajes() {
        String mensaje="No hay mensajes";
        try {

            // Retrieve a reference to a queue.
            CloudQueue queue = ObtenerColaDeMensajeria("adn");

            // Peek at the next message.
            CloudQueueMessage peekedMessage = queue.retrieveMessage();

            // Output the message value.
            if (peekedMessage != null) {
                mensaje = peekedMessage.getMessageContentAsString();
                queue.deleteMessage(peekedMessage);
            }
        } catch (Exception e) {
            // Output the stack trace.
            e.printStackTrace();
        }
        return mensaje;
    }

    private CloudQueue ObtenerColaDeMensajeria(String nombreCola) throws URISyntaxException, StorageException {
        return clienteColaMensajeriaAzure.getQueueReference(nombreCola);
    }

    @PostMapping
    @ApiOperation("Enviar mensaje")
    public String enviarMensaje(@RequestBody ComandoMensaje mensaje) {
        try {

            // Retrieve a reference to a queue.
            CloudQueue queue = ObtenerColaDeMensajeria("adn");

            // Create the queue if it doesn't already exist.
            queue.createIfNotExists();

            // Create a message and add it to the queue.
            CloudQueueMessage message = new CloudQueueMessage(mensaje.getMensaje());
            queue.addMessage(message);
        } catch (Exception e) {
            // Output the stack trace.
            e.printStackTrace();
        }

        return "MensajeEnviado";
    }

}
