package com.ceiba.configuracion;

import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.ServicioActualizarAlquiler;
import com.ceiba.alquiler.servicio.ServicioCrearAlquiler;
import com.ceiba.alquiler.servicio.ServicioEliminarAlquiler;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.devolucion.puerto.repositorio.RepositorioDevolucion;
import com.ceiba.devolucion.servicio.ServicioCrearDevolucion;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.moto.servicio.ServicioActualizarMoto;
import com.ceiba.moto.servicio.ServicioCrearMoto;
import com.ceiba.moto.servicio.ServicioEliminarMoto;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }


    //
    @Bean
    public ServicioCrearAlquiler servicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler) {
        return new ServicioCrearAlquiler(repositorioAlquiler);
    }

    @Bean
    public ServicioActualizarAlquiler servicioActualizarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        return new ServicioActualizarAlquiler(repositorioAlquiler);
    }

    @Bean
    public ServicioEliminarAlquiler servicioEliminarAlquiler(RepositorioAlquiler repositorioAlquiler) {
        return new ServicioEliminarAlquiler(repositorioAlquiler);
    }


    //
    @Bean
    public ServicioCrearCliente ServicioCrearCliente(RepositorioCliente repositorioCliente) {
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
    public ServicioCrearDevolucion servicioCrearDevolucion(RepositorioDevolucion repositorioDevolucion) {
        return new ServicioCrearDevolucion(repositorioDevolucion);
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
}
