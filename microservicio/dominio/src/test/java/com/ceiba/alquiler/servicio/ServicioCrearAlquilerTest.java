package com.ceiba.alquiler.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.alquiler.excepcion.AlquilerException;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.moto.puerto.dao.DaoMoto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ServicioCrearAlquilerTest {

    private static final String EL_CLIENTE_QUE_INTENTA_REALIZAR_EL_ALQUILER_NO_EXISTE_EN_EL_SISTEMA = "El cliente que realizar el alquiler no existe en el sistema";
    private static final String LA_MOTO_QUE_INTENTA_ALQUILAR_NO_EXISTE_EN_EL_SISTEMA = "La moto que intenta alquilar no existe en el sistema";
    private static final String LA_MOTO_QUE_INTENTA_ALQUILAR_SE_ENCUENTRA_OCUPADA = "La moto que intenta alquilar se encuentra ocupada.";
    private static final String LIMITE_DE_DIAS_ALQUILER_SUPERADO = "Limite de dias de alquiler superado.";
    private static final String DEBE_SOLICITAR_SU_ALQUILER_CON_MINIMO_DOS_DIAS_DE_ANTICIPACION = "Debe solicitar su alquiler con mínimo dos días de anticipación.";
    private static final String FORMATO_FECHA = "yyyy-MM-dd";
    private static final String FECHA_ALQUILER = "2021-03-05";
    private static final String FECHA_ENTREGA = "2021-03-04";
    private static final String FECHA_ENTREGA_DOS = "2021-03-12";
    private static final String FECHA_ALQUILER_INVALIDA = "2021-02-30";
    private static final String FECHA_ENTREGA_INVALIDA = "2021-03-32";
    private static final String FECHA_ALQUILER_FORMATO_INVALIDO = "01-02-2021";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_ALQUILER = "Se debe ingresar la fecha de alquiler";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_ENTREGA = "Se debe ingresar la fecha de entrega";
    private static final String FORMATO_DE_FECHA_DE_ALQUILER_INCORRECTO = "Formato de fecha de alquiler incorrecto";
    private static final String FORMATO_DE_FECHA_DE_ENTREGA_INCORRECTO = "Formato de fecha de entrega incorrecto";
    private static final String LA_FECHA_DE_ALQUILER_ES_INVALIDA = "La fecha de alquiler es invalida";
    private static final String LA_FECHA_DE_ENTREGA_ES_INVALIDA = "La fecha de entrega es invalida";
    private static final String LA_FECHA_DE_ALQUILER_DEBE_SER_MENOR_A_LA_FECHA_DE_ENTREGA = "La fecha de alquiler debe ser menor a la fecha de entrega";
    private static final String DEBE_INGRESAR_UN_ID_DE_CLIENTE = "Debe ingresar un identificador de cliente";
    private static final String DEBE_INGRESAR_UN_ID_DE_MOTO = "Debe ingresar un identificador de moto";
    private static final Double VALOR_ALQUILER_MOTO = 200000D;


    @Mock
    private RepositorioAlquiler repositorioAlquiler;

    @Mock
    private RepositorioCliente repositorioCliente;

    @Mock
    private RepositorioMoto repositorioMoto;

    @Mock
    private DaoMoto daoMoto;

    @InjectMocks
    private ServicioCrearAlquiler servicioCrearAlquiler;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExcepcionExistenciaClienteParaAlquilerTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        Mockito.when(repositorioCliente.existePorId(alquiler.getIdCliente())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.validarExistenciaPreviaCliente(alquiler.getIdCliente()), AlquilerException.class, EL_CLIENTE_QUE_INTENTA_REALIZAR_EL_ALQUILER_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarExcepcionExistenciaMotoParaAlquilerTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        Mockito.when(repositorioMoto.existePorId(alquiler.getIdMoto())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.validarExistenciaMoto(alquiler.getIdMoto()), AlquilerException.class, LA_MOTO_QUE_INTENTA_ALQUILAR_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarExcepcionExistenciaAlquierMotoParaFechasSeleccionadasTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        Mockito.when(repositorioAlquiler.existeAlquilerPorFechasParaMoto(alquiler.getFechaAlquiler(), alquiler.getIdMoto())).thenReturn(true);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.validarExistenciaAlquilerActualDeMoto(alquiler.getFechaAlquiler(), alquiler.getIdMoto()), AlquilerException.class, LA_MOTO_QUE_INTENTA_ALQUILAR_SE_ENCUENTRA_OCUPADA);
    }


    @Test
    public void validarExcepcionNumeroDiasParaAlquilerTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().
                conFechaEntrega(FECHA_ENTREGA_DOS).
                build();

        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.validarNumeroDiasAlquiler(alquiler.getFechaAlquiler(), alquiler.getFechaEntrega()), AlquilerException.class, LIMITE_DE_DIAS_ALQUILER_SUPERADO);
    }

    @Test
    public void validarNumeroDiasAnticipacionSolicitudAlquilerTest() {
        // arrange
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        LocalDate fechaActual = LocalDate.now();

        Alquiler alquiler = new AlquilerTestDataBuilder().
                conFechaAlquiler(fechaActual.format(formatter)).
                build();
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.validarNumeroDiasAnticipacionSolicitudAlquiler(alquiler.getFechaAlquiler()), AlquilerException.class, DEBE_SOLICITAR_SU_ALQUILER_CON_MINIMO_DOS_DIAS_DE_ANTICIPACION);
    }

    @Test
    public void validarExistenciaFinesSemanaAlquilerTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();

        // act
        boolean hayFinesDeSemana = servicioCrearAlquiler.validarExistenciaFinesSemanaAlquiler(alquiler.getFechaAlquiler(), alquiler.getFechaEntrega());

        // assert
        BasePrueba.assertEqualsObject(hayFinesDeSemana, true);
    }

    @Test
    public void validarNoExistenciaFinesSemanaAlquilerTest() {

        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().
                conFechaEntrega(FECHA_ENTREGA).
                build();

        // act
        boolean hayFinesDeSemana = servicioCrearAlquiler.validarExistenciaFinesSemanaAlquiler(alquiler.getFechaAlquiler(), alquiler.getFechaEntrega());

        // assert
        BasePrueba.assertEqualsObject(hayFinesDeSemana, false);
    }


    @Test
    public void validarObligatorioFechaAlquilerTest() {
        // arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conFechaAlquiler(null);
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_FECHA_DE_ALQUILER);
    }

    @Test
    public void validarLongitudFechaAlquilerTest() {
        // arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conFechaAlquiler("");
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionLongitudValor.class, SE_DEBE_INGRESAR_LA_FECHA_DE_ALQUILER);
    }

    @Test
    public void validarFormatoFechaAlquilerTest() {
        // arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conFechaAlquiler(FECHA_ALQUILER_FORMATO_INVALIDO);
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionValorInvalido.class, FORMATO_DE_FECHA_DE_ALQUILER_INCORRECTO);
    }

    @Test
    public void validarFechaAlquilerCorrectaTest() {
        // arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conFechaAlquiler(FECHA_ALQUILER_INVALIDA);
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionValorInvalido.class, LA_FECHA_DE_ALQUILER_ES_INVALIDA);
    }

    @Test
    public void validarObligatorioFechaEntregaAlquilerTest() {
        // arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conFechaEntrega(null);
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_FECHA_DE_ENTREGA);
    }

    @Test
    public void validarLongitudFechaEntregaAlquilerTest() {
        // arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conFechaEntrega("");
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionLongitudValor.class, SE_DEBE_INGRESAR_LA_FECHA_DE_ENTREGA);
    }

    @Test
    public void validarFormatoFechaEntregaAlquilerTest() {
        // arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conFechaEntrega(FECHA_ALQUILER_FORMATO_INVALIDO);
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionValorInvalido.class, FORMATO_DE_FECHA_DE_ENTREGA_INCORRECTO);
    }

    @Test
    public void validarFechaEntregaCorrectaTest() {
        // arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conFechaEntrega(FECHA_ENTREGA_INVALIDA);
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionValorInvalido.class, LA_FECHA_DE_ENTREGA_ES_INVALIDA);
    }

    @Test
    public void validarFechaAlquilerMenorAFechaEntregaCorrectaTest() {
        // arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().
                conFechaAlquiler(FECHA_ALQUILER).
                conFechaEntrega(FECHA_ENTREGA);
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionValorInvalido.class, LA_FECHA_DE_ALQUILER_DEBE_SER_MENOR_A_LA_FECHA_DE_ENTREGA);
    }

    @Test
    public void validarObligatorioIdClienteTest() {
        // arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conIdCliente(null);
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionValorObligatorio.class, DEBE_INGRESAR_UN_ID_DE_CLIENTE);
    }

    @Test
    public void validarObligatorioIdMotoTest() {
        // arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conIdMoto(null);
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionValorObligatorio.class, DEBE_INGRESAR_UN_ID_DE_MOTO);
    }

    @Test
    public void validarCreacionAlquilerTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().
                conId(1L).
                build();
        Mockito.when(repositorioCliente.existePorId(alquiler.getIdCliente())).thenReturn(true);
        Mockito.when(repositorioMoto.existePorId(alquiler.getIdMoto())).thenReturn(true);
        Mockito.when(repositorioAlquiler.existeAlquilerPorFechasParaMoto(alquiler.getFechaAlquiler(), alquiler.getIdMoto())).thenReturn(false);
        Mockito.when(daoMoto.obtenerCostoAlquiler(alquiler.getId())).thenReturn(VALOR_ALQUILER_MOTO);

        Mockito.when(repositorioAlquiler.crear(alquiler)).thenReturn(1L);


        // act
        Long idAlquiler = servicioCrearAlquiler.ejecutar(alquiler);
        // assert
        BasePrueba.assertEqualsObject(alquiler.getId(), idAlquiler);
    }
}
