package com.ceiba.cola_mensajeria.adaptador.obtener_mensajes_azure;

import com.ceiba.cola_mensajeria.modelo.dto.DtoMensaje;
import com.ceiba.cola_mensajeria.puerto.obtener_mensajes.ObtenerMensajes;
import com.ceiba.configuracion.ClienteColaMensajeriaAzure;
import com.microsoft.azure.storage.queue.CloudQueue;
import com.microsoft.azure.storage.queue.CloudQueueClient;
import com.microsoft.azure.storage.queue.CloudQueueMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

@Component
public class ObtenerMensajesAzure implements ObtenerMensajes {

    private final CloudQueueClient clienteColaMensajeriaAzure;

    @Autowired
    public ObtenerMensajesAzure(ClienteColaMensajeriaAzure clienteColaMensajeriaAzure) throws URISyntaxException, InvalidKeyException {
        this.clienteColaMensajeriaAzure = clienteColaMensajeriaAzure.clienteColaMensajería();
    }


    @Override
    public DtoMensaje obtenerMensajeUnico(String nombreCola) {
        String mensajeRespuesta = "No hay mensajes";
        try {

            // Retrieve a reference to a queue.
            CloudQueue queue = clienteColaMensajeriaAzure.getQueueReference(nombreCola);

            // Peek at the next message.
            CloudQueueMessage mensajeCola = queue.retrieveMessage();

            // Output the message value.
            if (mensajeCola != null) {
                mensajeRespuesta = mensajeCola.getMessageContentAsString();
                queue.deleteMessage(mensajeCola);
            }
        } catch (Exception e) {
            // Output the stack trace.
            e.printStackTrace();
        }
        return new DtoMensaje(mensajeRespuesta);
    }
}
