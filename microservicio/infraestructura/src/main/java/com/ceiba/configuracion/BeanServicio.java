package com.ceiba.configuracion;

import com.ceiba.alquiler.puerto.dao.DaoAlquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.ServicioActualizarAlquiler;
import com.ceiba.alquiler.servicio.ServicioCrearAlquiler;
import com.ceiba.alquiler.servicio.ServicioEliminarAlquiler;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.cola_mensajeria.puerto.envio_mensaje.EnvioMensaje;
import com.ceiba.cola_mensajeria.servicio.ServicioEnviarMensaje;
import com.ceiba.devolucion.puerto.repositorio.RepositorioDevolucion;
import com.ceiba.devolucion.servicio.ServicioCrearDevolucion;
import com.ceiba.moto.puerto.dao.DaoMoto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.moto.servicio.ServicioActualizarMoto;
import com.ceiba.moto.servicio.ServicioCrearMoto;
import com.ceiba.moto.servicio.ServicioEliminarMoto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    //
    @Bean
    public ServicioCrearAlquiler servicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler, RepositorioCliente repositorioCliente, RepositorioMoto repositorioMoto, DaoMoto daoMoto) {
        return new ServicioCrearAlquiler(repositorioAlquiler, repositorioCliente, repositorioMoto, daoMoto);
    }

    @Bean
    public ServicioActualizarAlquiler servicioActualizarAlquiler(RepositorioAlquiler repositorioAlquiler, RepositorioCliente repositorioCliente, RepositorioMoto repositorioMoto, DaoMoto daoMoto) {
        return new ServicioActualizarAlquiler(repositorioAlquiler, repositorioCliente, repositorioMoto, daoMoto);
    }

    @Bean
    public ServicioEliminarAlquiler servicioEliminarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        return new ServicioEliminarAlquiler(repositorioAlquiler);
    }


    //
    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente) {
        return new ServicioCrearCliente(repositorioCliente);
    }

    @Bean
    public ServicioActualizarCliente servicioActualizarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioActualizarCliente(repositorioCliente);
    }

    @Bean
    public ServicioEliminarCliente servicioEliminarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioEliminarCliente(repositorioCliente);
    }

    //
    @Bean
    public ServicioCrearDevolucion servicioCrearDevolucion(RepositorioDevolucion repositorioDevolucion, RepositorioAlquiler repositorioAlquiler, RepositorioMoto repositorioMoto, DaoAlquiler daoAlquiler) {
        return new ServicioCrearDevolucion(repositorioDevolucion, repositorioAlquiler, repositorioMoto, daoAlquiler);
    }

    //
    @Bean
    public ServicioCrearMoto servicioCrearMoto(RepositorioMoto repositorioMoto) {
        return new ServicioCrearMoto(repositorioMoto);
    }

    @Bean
    public ServicioActualizarMoto servicioActualizarMoto(RepositorioMoto repositorioMoto) {
        return new ServicioActualizarMoto(repositorioMoto);
    }

    @Bean
    public ServicioEliminarMoto servicioEliminarMoto(RepositorioMoto repositorioMoto) {
        return new ServicioEliminarMoto(repositorioMoto);
    }

    @Bean
    public ServicioEnviarMensaje servicioEnviarMensaje(EnvioMensaje envioMensaje) {
        return new ServicioEnviarMensaje(envioMensaje);
    }
}
