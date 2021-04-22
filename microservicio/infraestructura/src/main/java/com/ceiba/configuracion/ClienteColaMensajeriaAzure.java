package com.ceiba.configuracion;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.queue.CloudQueueClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

@Configuration
public class ClienteColaMensajeriaAzure {

    private CloudStorageAccount almacenamientoAzure;

    @Autowired
    public ClienteColaMensajeriaAzure(AlmacenamientoAzure almacenamientoAzure) throws URISyntaxException, InvalidKeyException {
        this.almacenamientoAzure = almacenamientoAzure.cuentaAlmacenamiento();
    }

    @Bean
    public CloudQueueClient clienteColaMensajería(){
        return almacenamientoAzure.createCloudQueueClient();
    }
}
