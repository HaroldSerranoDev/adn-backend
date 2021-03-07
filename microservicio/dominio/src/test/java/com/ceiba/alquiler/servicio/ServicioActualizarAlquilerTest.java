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

public class ServicioActualizarAlquilerTest {

    private static final String EL_ALQUILER_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA = "El alquiler que intenta actualizar no existe en el sistema";
    private static final Double VALOR_ALQUILER_MOTO = 200000D;
    private static final String FECHA_ALQUILER_FUTURO = "2030-01-04";
    private static final String FECHA_ENTREGA_FUTURO = "2030-01-07";
    private static final String FECHA_ALQUILER_FUTURO_DOS = "2030-01-01";
    private static final String FECHA_ENTREGA_FUTURO_DOS = "2030-01-04";


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
        BasePrueba.assertThrows(() -> servicioActualizarAlquiler.ejecutar(alquiler), AlquilerException.class, EL_ALQUILER_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA);
    }


    @Test
    public void validarActualizacionAlquilerTest() {
        // arrange

        Alquiler alquiler = new AlquilerTestDataBuilder().
                conId(1L).
                conFechaAlquiler(FECHA_ALQUILER_FUTURO_DOS).
                conFechaEntrega(FECHA_ENTREGA_FUTURO_DOS).
                build();

        Mockito.when(repositorioCliente.existePorId(alquiler.getIdCliente())).thenReturn(true);
        Mockito.when(repositorioMoto.existePorId(alquiler.getIdMoto())).thenReturn(true);
        Mockito.when(repositorioAlquiler.existeAlquilerPorFechasParaMoto(alquiler.getFechaAlquiler(), alquiler.getFechaEntrega(), alquiler.getIdMoto(), alquiler.getId())).thenReturn(false);
        Mockito.when(repositorioAlquiler.existePorId(alquiler.getId())).thenReturn(true);
        Mockito.when(daoMoto.obtenerCostoAlquiler(alquiler.getId())).thenReturn(VALOR_ALQUILER_MOTO);
        // act
        servicioActualizarAlquiler.ejecutar(alquiler);

        // assert
        Mockito.verify(repositorioAlquiler).actualizar(alquiler);
    }


    @Test
    public void validarActualizacionAlquilerConFinesDeSemanaTest() {

        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().
                conId(1L).
                conFechaAlquiler(FECHA_ALQUILER_FUTURO).
                conFechaEntrega(FECHA_ENTREGA_FUTURO).
                build();

        Mockito.when(repositorioMoto.existePorId(alquiler.getIdMoto())).thenReturn(true);
        Mockito.when(repositorioCliente.existePorId(alquiler.getIdCliente())).thenReturn(true);
        Mockito.when(daoMoto.obtenerCostoAlquiler(alquiler.getId())).thenReturn(VALOR_ALQUILER_MOTO);
        Mockito.when(repositorioAlquiler.existePorId(alquiler.getId())).thenReturn(true);
        Mockito.when(repositorioAlquiler.existePorId(alquiler.getId())).thenReturn(true);
        Mockito.when(repositorioAlquiler.existeAlquilerPorFechasParaMoto(alquiler.getFechaAlquiler(), alquiler.getFechaEntrega(), alquiler.getIdMoto(), alquiler.getId())).thenReturn(false);

        // act
        servicioActualizarAlquiler.ejecutar(alquiler);
        // assert
        Mockito.verify(repositorioAlquiler).actualizar(alquiler);
    }
}
