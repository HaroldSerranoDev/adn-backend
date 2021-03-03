package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.excepcion.ClienteException;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioEliminarClienteTest {

    private static final String EL_CLIENTE_QUE_INTENTA_ELIMINAR_NO_EXISTE_EN_EL_SISTEMA = "El cliente que intenta eliminar no existe en el sistema";

    @Mock
    private RepositorioCliente repositorioCliente;

    @InjectMocks
    private ServicioEliminarCliente servicioEliminarCliente;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExcepcionClienteSinExistenciaPreviaTest() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().
                conId(1L).
                build();
        Mockito.when(repositorioCliente.existePorId(cliente.getId())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarCliente.ejecutar(cliente.getId()), ClienteException.class, EL_CLIENTE_QUE_INTENTA_ELIMINAR_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarActualizacionClienteTest() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().
                conId(1L).
                build();
        Mockito.when(repositorioCliente.existePorId(cliente.getId())).thenReturn(true);

        // act
        servicioEliminarCliente.ejecutar(cliente.getId());

        // assert
        Mockito.verify(repositorioCliente).eliminar(cliente.getId());
    }
}
