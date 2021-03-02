package com.ceiba.alquiler.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.alquiler.excepcion.AlquilerException;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioEliminarAlquilerTest {

    private static final String EL_ALQUILER_QUE_INTENTA_ELIMINAR_NO_EXISTE_EN_EL_SISTEMA = "El alquiler que intenta eliminar no existe en el sistema";

    @Mock
    private RepositorioAlquiler repositorioAlquiler;

    @InjectMocks
    private ServicioEliminarAlquiler servicioEliminarAlquiler;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExcepcionAlquilerSinExistenciaPreviaTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().
                conId(1L).
                build();
        Mockito.when(repositorioAlquiler.existePorId(alquiler.getId())).thenReturn(false);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarAlquiler.ejecutar(alquiler.getId()), AlquilerException.class, EL_ALQUILER_QUE_INTENTA_ELIMINAR_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarEliminacionAlquilerTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().
                conId(1L).
                build();
        Mockito.when(repositorioAlquiler.existePorId(alquiler.getId())).thenReturn(true);

        // act
        servicioEliminarAlquiler.ejecutar(alquiler.getId());

        // assert
        Mockito.verify(repositorioAlquiler).eliminar(alquiler.getId());
    }
}
