package com.ceiba.cola_mensajeria.adaptador.enviar_mensaje;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.ceiba.cola_mensajeria.puerto.envio_mensaje.EnvioMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("envioMensajeBusServicioAzure")
public class EnvioMensajeBusServicioAzure implements EnvioMensaje {

    private final ServiceBusClientBuilder clienteEnvioMensajeriaAzure;

    @Autowired
    public EnvioMensajeBusServicioAzure(ServiceBusClientBuilder clienteEnvioMensajeriaAzure) {
        this.clienteEnvioMensajeriaAzure = clienteEnvioMensajeriaAzure;
    }

    @Override
    public void enviarMensaje(String nombreCola, String mensaje) {
        ServiceBusSenderClient clienteEnvio = clienteEnvioMensajeriaAzure.
                sender().
                queueName(nombreCola).
                buildClient();
        clienteEnvio.sendMessage(new ServiceBusMessage(mensaje));
    }
}
