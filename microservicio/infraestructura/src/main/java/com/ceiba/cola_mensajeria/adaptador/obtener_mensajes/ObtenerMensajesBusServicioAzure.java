package com.ceiba.cola_mensajeria.adaptador.obtener_mensajes;

import com.azure.messaging.servicebus.*;
import com.ceiba.cola_mensajeria.modelo.dto.DtoMensaje;
import com.ceiba.cola_mensajeria.puerto.obtener_mensajes.ObtenerMensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("obtenerMensajesBusServicioAzure")
public class ObtenerMensajesBusServicioAzure implements ObtenerMensajes {

    private final ServiceBusClientBuilder clienteEnvioMensajeriaAzure;

    @Autowired
    public ObtenerMensajesBusServicioAzure(ServiceBusClientBuilder clienteEnvioMensajeriaAzure) {
        this.clienteEnvioMensajeriaAzure = clienteEnvioMensajeriaAzure;
    }


    @Override
    public DtoMensaje obtenerMensajeUnico(String nombreCola) {

        ServiceBusProcessorClient clienteEnvio = clienteEnvioMensajeriaAzure.
                processor().
                queueName(nombreCola).
                processMessage(mensajeProcesado -> processMessage(mensajeProcesado)).
                processError(errorProcesado -> processError(errorProcesado)).
                buildProcessorClient();

        clienteEnvio.start();
        return new DtoMensaje("Los mensajes están siendo solicitados al servicio de bus");
    }

    private static void processMessage(ServiceBusReceivedMessageContext context) {
        ServiceBusReceivedMessage message = context.getMessage();
        System.out.printf("Mensaje: %s%n", message.getBody());
    }

    private static void processError(ServiceBusErrorContext context) {
       System.out.println(context.getException().getMessage());
    }
}
