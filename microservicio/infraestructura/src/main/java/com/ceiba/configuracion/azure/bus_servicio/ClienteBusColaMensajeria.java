package com.ceiba.configuracion.azure.bus_servicio;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBusColaMensajeria {

    @Value("${spring.cloud.azure.servicebus.endpoint}")
    private String conexion;

    @Bean
    public ServiceBusClientBuilder clienteServicioBusMensajería() {
        return new ServiceBusClientBuilder()
                .connectionString(conexion);
    }
}
