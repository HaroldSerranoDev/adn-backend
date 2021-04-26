package com.ceiba.configuracion.azure.almacenamiento;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.queue.CloudQueueClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

@Configuration
public class ClienteColaMensajeria {

    private CloudStorageAccount almacenamientoAzure;

    @Autowired
    public ClienteColaMensajeria(CloudStorageAccount almacenamiento) throws URISyntaxException, InvalidKeyException {
        this.almacenamientoAzure = almacenamiento;
    }

    @Bean
    public CloudQueueClient clienteColaMensajería(){
        return almacenamientoAzure.createCloudQueueClient();
    }
}
