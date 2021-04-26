package com.ceiba.configuracion.azure.almacenamiento;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteArchivo {

    private CloudStorageAccount almacenamientoAzure;

    @Autowired
    public ClienteArchivo(CloudStorageAccount almacenamiento) {
        this.almacenamientoAzure = almacenamiento;
    }

    @Bean
    public CloudBlobClient obtenerclienteArchivo() {
        return almacenamientoAzure.createCloudBlobClient();
    }
}
