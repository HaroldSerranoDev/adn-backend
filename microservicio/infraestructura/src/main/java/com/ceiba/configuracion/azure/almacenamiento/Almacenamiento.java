package com.ceiba.configuracion.azure.almacenamiento;

import com.microsoft.azure.storage.CloudStorageAccount;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

@Configuration
public class Almacenamiento {

    @Value("${spring.cloud.azure.almacenamiento.nombre}")
    private String nombreCuenta;

    @Value("${spring.cloud.azure.almacenamiento.clave}")
    private String claveCuenta;

    @Primary
    @Bean
    public CloudStorageAccount cuentaAlmacenamiento() throws URISyntaxException, InvalidKeyException {
        String storageConnectionString = "DefaultEndpointsProtocol=https;" +
                "AccountName=" + nombreCuenta + ";" +
                "AccountKey=" + claveCuenta;

        return CloudStorageAccount.parse(storageConnectionString);
    }

}
