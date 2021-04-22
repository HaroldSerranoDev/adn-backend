package com.ceiba.configuracion;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

@Configuration
public class ClienteArchivoAzure {

    private CloudStorageAccount almacenamientoAzure;

    @Autowired
    public ClienteArchivoAzure(AlmacenamientoAzure almacenamientoAzure) throws URISyntaxException, InvalidKeyException {
        this.almacenamientoAzure = almacenamientoAzure.cuentaAlmacenamiento();
    }

    @Bean
    public CloudBlobClient clienteArchivo() {
        return almacenamientoAzure.createCloudBlobClient();
    }
}
