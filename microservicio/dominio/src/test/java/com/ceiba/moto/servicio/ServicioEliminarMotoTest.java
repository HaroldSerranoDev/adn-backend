package com.ceiba.moto.servicio;

import com.ceiba.BasePrueba;
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

public class ServicioEliminarMotoTest {

    private static final String LA_MOTO_QUE_INTENTA_ELIMINAR_NO_EXISTE_EN_EL_SISTEMA = "La moto que intenta eliminar no existe en el sistema";

    @Mock
    private RepositorioMoto repositorioMoto;

    @InjectMocks
    private ServicioEliminarMoto servicioEliminarMoto;

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
        BasePrueba.assertThrows(() -> servicioEliminarMoto.ejecutar(moto.getId()), MotoException.class, LA_MOTO_QUE_INTENTA_ELIMINAR_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarActualizacionMotoTest() {
        // arrange
        Moto moto = new MotoTestDataBuilder().
                conId(1L).
                build();
        Mockito.when(repositorioMoto.existePorId(moto.getId())).thenReturn(true);

        // act
        servicioEliminarMoto.ejecutar(moto.getId());

        // assert
        Mockito.verify(repositorioMoto).eliminar(moto.getId());
    }
}
