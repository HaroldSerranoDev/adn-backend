package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioCrearClienteTest {

    private static final String EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA = "El cliente ya existe en el sistema";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE = "Se debe ingresar el nombre del cliente";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION_DEL_CLIENTE = "Se debe ingresar la direccion del cliente";
    private static final String SE_DEBE_INGRESAR_EL_TELEFONO_DEL_CLIENTE = "Se debe ingresar el telefono del cliente";
    private static final String SE_DEBE_INGRESAR_LA_CEDULA_DEL_CLIENTE = "Se debe ingresar la cédula del cliente";
    private static final String SE_DEBE_INGRESAR_EL_CORREO_DEL_CLIENTE = "Se debe ingresar el correo del cliente";
    private static final String DEBE_INGRESAR_UN_VALOR_NUMERICO_PARA_EL_TELEFONO = "Debe ingresar un valor númerico para el telefono";
    private static final String DEBE_INGRESAR_UN_VALOR_NUMERICO_PARA_LA_CEDULA = "Debe ingresar un valor númerico para la cédula";
    private static final String DEBE_INGRESAR_UN_FORMATO_DE_CORREO_VALIDO = "Debe ingresar un formato de correo válido";


    @Mock
    private RepositorioCliente repositorioCliente;

    @InjectMocks
    private ServicioCrearCliente servicioCrearCliente;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExcepcionClienteConExistenciaPreviaTest() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        Mockito.when(repositorioCliente.existePorCedulaOCorreoExcluyendoId(cliente.getCedula(), cliente.getCorreo(), cliente.getId())).thenReturn(true);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCliente.validarExistenciaPreviaCliente(cliente), ExcepcionDuplicidad.class, EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarObligatorioNombreClienteTest() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombre(null);
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE);
    }

    @Test
    public void validarLongitudNombreClienteTest() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombre("");
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_CLIENTE);
    }


    @Test
    public void validarObligatorioDireccionClienteTest() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conDireccion(null);
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_DIRECCION_DEL_CLIENTE);
    }

    @Test
    public void validarLongitudDireccionClienteTest() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conDireccion("");
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class, SE_DEBE_INGRESAR_LA_DIRECCION_DEL_CLIENTE);
    }

    @Test
    public void validarObligatorioTelefonoClienteTest() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conTelefono(null);
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_TELEFONO_DEL_CLIENTE);
    }

    @Test
    public void validarLongitudTelefonoClienteTest() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conTelefono("");
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class, SE_DEBE_INGRESAR_EL_TELEFONO_DEL_CLIENTE);
    }

    @Test
    public void validarTelefonoNumericoClienteTest() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conTelefono("numero");
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorInvalido.class, DEBE_INGRESAR_UN_VALOR_NUMERICO_PARA_EL_TELEFONO);
    }

    @Test
    public void validarObligatorioCedulaClienteTest() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conCedula(null);
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_CEDULA_DEL_CLIENTE);
    }

    @Test
    public void validarLongitudCedulaClienteTest() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conCedula("");
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class, SE_DEBE_INGRESAR_LA_CEDULA_DEL_CLIENTE);
    }

    @Test
    public void validarCedulaNumericaClienteTest() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conCedula("numero");
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorInvalido.class, DEBE_INGRESAR_UN_VALOR_NUMERICO_PARA_LA_CEDULA);
    }

    @Test
    public void validarObligatorioCorreoClienteTest() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conCorreo(null);
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_EL_CORREO_DEL_CLIENTE);
    }

    @Test
    public void validarLongitudCorreoClienteTest() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conCorreo("");
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class, SE_DEBE_INGRESAR_EL_CORREO_DEL_CLIENTE);
    }

    @Test
    public void validarFormatoCorreoClienteTest() {
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conCorreo("prueba.com");
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorInvalido.class, DEBE_INGRESAR_UN_FORMATO_DE_CORREO_VALIDO);
    }


    @Test
    public void validarCreacionClienteTest() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().
                conId(1L).
                build();
        Mockito.when(repositorioCliente.existePorCedulaOCorreoExcluyendoId(cliente.getCedula(), cliente.getCorreo(), cliente.getId())).thenReturn(false);
        Mockito.when(repositorioCliente.crear(cliente)).thenReturn(1L);

        // act
        Long idCliente = servicioCrearCliente.ejecutar(cliente);

        // assert
        BasePrueba.assertEqualsObject(cliente.getId(), idCliente);
    }
}
