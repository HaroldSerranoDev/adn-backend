package com.ceiba.devolucion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.alquiler.puerto.dao.DaoAlquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.devolucion.excepcion.DevolucionException;
import com.ceiba.devolucion.modelo.entidad.Devolucion;
import com.ceiba.devolucion.puerto.repositorio.RepositorioDevolucion;
import com.ceiba.devolucion.servicio.testdatabuilder.DevolucionTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioCrearDevolucionTest {

    private static final String EL_ALQUILER_PARA_EL_CUAL_INTENTA_HACER_LA_DEVOLUCION_NO_EXISTE = "El alquiler par el cual intenta hacer la devolucón no existe";
    private static final String LA_DEVOLUCION_QUE_INTENTA_REALIZAR_YA_EXISTE = "La devolucion que intenta realizar ya existe";
    private static final String DEBE_INGRESAR_LOS_KILOMETROS_FINALES_DE_LA_MOTO = "Debe ingresar los kilometros finales de la moto.";
    private static final String DEBE_INGRESAR_EL_IDENTIFICADOR_DEL_ALQUILER = "Debe ingresar el identificador del alquiler.";


    @Mock
    private RepositorioAlquiler repositorioAlquiler;

    @Mock
    private RepositorioDevolucion repositorioDevolucion;

    @Mock
    private RepositorioMoto repositorioMoto;

    @Mock
    private DaoAlquiler daoAlquiler;

    @InjectMocks
    private ServicioCrearDevolucion servicioCrearDevolucion;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExcepcionExistenciaAlquilerTest() {
        // arrange
        Devolucion devolucion = new DevolucionTestDataBuilder().build();
        Mockito.when(repositorioAlquiler.existePorId(devolucion.getIdAlquiler())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearDevolucion.validarExistenciaPreviaAlquiler(devolucion.getIdAlquiler()), DevolucionException.class, EL_ALQUILER_PARA_EL_CUAL_INTENTA_HACER_LA_DEVOLUCION_NO_EXISTE);
    }

    @Test
    public void validarExcepcionExistenciaDevolucionTest() {
        // arrange
        Devolucion devolucion = new DevolucionTestDataBuilder().build();
        Mockito.when(repositorioDevolucion.existePorIdAlquiler(devolucion.getIdAlquiler())).thenReturn(true);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearDevolucion.validarExistenciaPreviaDevolucionPorIdAlquiler(devolucion), DevolucionException.class, LA_DEVOLUCION_QUE_INTENTA_REALIZAR_YA_EXISTE);
    }

    @Test
    public void validarObligatorioKilometrosFinalesTest() {
        // arrange
        DevolucionTestDataBuilder alquilerTestDataBuilder = new DevolucionTestDataBuilder().conKilometrosFinales(null);
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionValorObligatorio.class, DEBE_INGRESAR_LOS_KILOMETROS_FINALES_DE_LA_MOTO);
    }

    @Test
    public void validarObligatorioIdAlquilerTest() {
        // arrange
        DevolucionTestDataBuilder alquilerTestDataBuilder = new DevolucionTestDataBuilder().conIdalquiler(null);
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionValorObligatorio.class, DEBE_INGRESAR_EL_IDENTIFICADOR_DEL_ALQUILER);
    }

}
