package com.ceiba.moto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.moto.excepcion.MotoException;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.moto.servicio.testdatabuilder.MotoTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioActualizarMotoTest {

    private static final String LA_MOTO_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA = "La moto que intenta actualizar no existe en el sistema";
    private static final String LA_MOTO_YA_EXISTE_EN_EL_SISTEMA = "La moto ya existe en el sistema";

    @Mock
    private RepositorioMoto repositorioMoto;

    @InjectMocks
    private ServicioActualizarMoto servicioActualizarMoto;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExcepcionMotoSinExistenciaPreviaTest() {
        // arrange
        Moto moto = new MotoTestDataBuilder().
                conId(1L).
                build();
        Mockito.when(repositorioMoto.existePorId(moto.getId())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarMoto.ejecutar(moto), MotoException.class, LA_MOTO_QUE_INTENTA_ACTUALIZAR_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarExcepcionMotoConExistenciaPreviaTest() {
        // arrange
        Moto moto = new MotoTestDataBuilder().build();
        Mockito.when(repositorioMoto.existePorId(moto.getId())).thenReturn(true);
        Mockito.when(repositorioMoto.existePorMatriculaExcluyendoId(moto.getMatricula(), moto.getId())).thenReturn(true);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarMoto.ejecutar(moto), ExcepcionDuplicidad.class, LA_MOTO_YA_EXISTE_EN_EL_SISTEMA);
    }


    @Test
    public void validarActualizacionMotoTest() {
        // arrange
        Moto moto = new MotoTestDataBuilder().
                conId(1L).
                build();
        Mockito.when(repositorioMoto.existePorId(moto.getId())).thenReturn(true);

        // act
        servicioActualizarMoto.ejecutar(moto);

        // assert
        Mockito.verify(repositorioMoto).actualizar(moto);
    }
}
