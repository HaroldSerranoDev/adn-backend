package com.ceiba.cola_mensajeria.adaptador.enviar_mensaje;

import com.ceiba.cola_mensajeria.puerto.envio_mensaje.EnvioMensaje;
import com.microsoft.azure.storage.queue.CloudQueue;
import com.microsoft.azure.storage.queue.CloudQueueClient;
import com.microsoft.azure.storage.queue.CloudQueueMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("envioMensajeAlmacenamientoAzure")
public class EnvioMensajeAlmacenamientoAzure implements EnvioMensaje {

    private final CloudQueueClient clienteColaMensajeriaAzure;

    @Autowired
    public EnvioMensajeAlmacenamientoAzure(CloudQueueClient clienteAlmacenamientoColaMensajeriaAzure){
        this.clienteColaMensajeriaAzure = clienteAlmacenamientoColaMensajeriaAzure;
    }

    @Override
    public void enviarMensaje(String nombreCola, String mensaje) {

        try {
            // Retrieve a reference to a queue.
            CloudQueue queue = clienteColaMensajeriaAzure.getQueueReference(nombreCola);

            // Create the queue if it doesn't already exist.
            queue.createIfNotExists();

            // Create a message and add it to the queue.
            CloudQueueMessage message = new CloudQueueMessage(mensaje);
            queue.addMessage(message);
        } catch (Exception e) {
            // Output the stack trace.
            e.printStackTrace();
        }
    }
}
