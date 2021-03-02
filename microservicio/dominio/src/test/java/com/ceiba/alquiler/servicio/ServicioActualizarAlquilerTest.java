package com.ceiba.alquiler.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.alquiler.excepcion.AlquilerException;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
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

public class ServicioActualizarAlquilerTest {

    private static final String EL_ALQUILER_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA = "El alquiler que intenta actualizar no existe en el sistema";private static final String EL_CLIENTE_QUE_INTENTA_REALIZAR_EL_ALQUILER_NO_EXISTE_EN_EL_SISTEMA = "El cliente que realizar el alquiler no existe en el sistema";
    private static final String LA_MOTO_QUE_INTENTA_ALQUILAR_NO_EXISTE_EN_EL_SISTEMA = "La moto que intenta alquilar no existe en el sistema";
    private static final String LA_MOTO_QUE_INTENTA_ALQUILAR_SE_ENCUENTRA_OCUPADA = "La moto que intenta alquilar se encuentra ocupada.";
    private static final String LIMITE_DE_DIAS_ALQUILER_SUPERADO = "Limite de dias de alquiler superado.";
    private static final String DEBE_SOLICITAR_EL_ALQUILER_CON_MINIMO_DOS_DIAS_DE_ANTICIPACION = "Debe solicitar su alquiler con mínimo dos dias de anticipación.";
    private static final String FORMATO_FECHA = "yyyy-MM-dd";
    private static final String FECHA_ENTREGA = "2021-03-04";
    private static final String FECHA_ENTREGA_DOS = "2021-03-12";
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
    private ServicioActualizarAlquiler servicioActualizarAlquiler;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExcepcionAlquilerSinExistenciaPreviaTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        Mockito.when(repositorioAlquiler.existePorId(alquiler.getId())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAlquiler.validarExistenciaPreviaAlquiler(alquiler), AlquilerException.class, EL_ALQUILER_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarExcepcionExistenciaClienteParaAlquilerTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        Mockito.when(repositorioCliente.existePorId(alquiler.getIdCliente())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAlquiler.validarExistenciaPreviaCliente(alquiler.getIdCliente()), AlquilerException.class, EL_CLIENTE_QUE_INTENTA_REALIZAR_EL_ALQUILER_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarExcepcionExistenciaMotoParaAlquilerTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        Mockito.when(repositorioMoto.existePorId(alquiler.getIdMoto())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAlquiler.validarExistenciaMoto(alquiler.getIdMoto()), AlquilerException.class, LA_MOTO_QUE_INTENTA_ALQUILAR_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarExcepcionExistenciaAlquierMotoParaFechasSeleccionadasTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        Mockito.when(repositorioAlquiler.existeAlquilerPorFechasParaMoto(alquiler.getFechaAlquiler(), alquiler.getIdMoto())).thenReturn(true);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAlquiler.validarExistenciaAlquilerActualDeMoto(alquiler.getFechaAlquiler(), alquiler.getIdMoto()), AlquilerException.class, LA_MOTO_QUE_INTENTA_ALQUILAR_SE_ENCUENTRA_OCUPADA);
    }


    @Test
    public void validarExcepcionNumeroDiasParaAlquilerTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().
                conFechaEntrega(FECHA_ENTREGA_DOS).
                build();

        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAlquiler.validarNumeroDiasAlquiler(alquiler.getFechaAlquiler(),alquiler.getFechaEntrega()), AlquilerException.class, LIMITE_DE_DIAS_ALQUILER_SUPERADO);
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
        BasePrueba.assertThrows(() -> servicioActualizarAlquiler.validarNumeroDiasAnticipacionSolicitudAlquiler(alquiler.getFechaAlquiler()), AlquilerException.class, DEBE_SOLICITAR_EL_ALQUILER_CON_MINIMO_DOS_DIAS_DE_ANTICIPACION);
    }

    @Test
    public void validarExistenciaFinesSemanaAlquilerTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();

        // act
        boolean hayFinesDeSemana = servicioActualizarAlquiler.validarExistenciaFinesSemanaAlquiler(alquiler.getFechaAlquiler(),alquiler.getFechaEntrega());

        // assert
        BasePrueba.assertEqualsObject(hayFinesDeSemana,true);
    }

    @Test
    public void validarNoExistenciaFinesSemanaAlquilerTest() {

        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().
                conFechaEntrega(FECHA_ENTREGA).
                build();

        // act
        boolean hayFinesDeSemana = servicioActualizarAlquiler.validarExistenciaFinesSemanaAlquiler(alquiler.getFechaAlquiler(),alquiler.getFechaEntrega());

        // assert
        BasePrueba.assertEqualsObject(hayFinesDeSemana,false);
    }

    @Test
    public void validarActualizacionAlquilerTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().
                conId(1L).
                build();
        Mockito.when(repositorioAlquiler.existePorId(alquiler.getId())).thenReturn(true);
        Mockito.when(repositorioCliente.existePorId(alquiler.getIdCliente())).thenReturn(true);
        Mockito.when(repositorioMoto.existePorId(alquiler.getIdMoto())).thenReturn(true);
        Mockito.when(repositorioAlquiler.existeAlquilerPorFechasParaMoto(alquiler.getFechaAlquiler(), alquiler.getIdMoto())).thenReturn(false);
        Mockito.when(daoMoto.obtenerCostoAlquiler(alquiler.getId())).thenReturn(VALOR_ALQUILER_MOTO);
        // act
        servicioActualizarAlquiler.ejecutar(alquiler);

        // assert
        Mockito.verify(repositorioAlquiler).actualizar(alquiler);
    }
}
