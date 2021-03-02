package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.excepcion.ClienteException;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioActualizarClienteTest {

    private static final String EL_CLIENTE_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA = "El cliente que intenta actualizar no existe en el sistema";
    private static final String EL_CORREO_O_LA_CEDULA_QUE_INTENTA_ASIGNAR_YA_EXISTE = "El correo o la cédula que intenta asignar, ya existe.";

    @Mock
    private RepositorioCliente repositorioCliente;

    @InjectMocks
    private ServicioActualizarCliente servicioActualizarCliente;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExcepcionClienteSinExistenciaPreviaTest() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        Mockito.when(repositorioCliente.existePorId(cliente.getId())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCliente.validarExistenciaPreviaCliente(cliente), ClienteException.class, EL_CLIENTE_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA);
    }


    @Test
    public void validarExcepcionCedulaOCorreoYaRegistradoTest() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        Mockito.when(repositorioCliente.existePorCedulaOCorreoExcluyendoId(cliente.getCedula(), cliente.getCorreo(), cliente.getId())).thenReturn(true);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCliente.validarExistenciaDeCedulaOCorreo(cliente), ExcepcionDuplicidad.class, EL_CORREO_O_LA_CEDULA_QUE_INTENTA_ASIGNAR_YA_EXISTE);
    }


    @Test
    public void validarActualizacionClienteTest() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().
                conId(1L).
                build();
        Mockito.when(repositorioCliente.existePorId(cliente.getId())).thenReturn(true);
        Mockito.when(repositorioCliente.existePorCedulaOCorreoExcluyendoId(cliente.getCedula(), cliente.getCorreo(), cliente.getId())).thenReturn(false);

        // act
        servicioActualizarCliente.ejecutar(cliente);

        // assert
        Mockito.verify(repositorioCliente).actualizar(cliente);
    }
}
