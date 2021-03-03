package com.ceiba.moto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.puerto.repositorio.RepositorioMoto;
import com.ceiba.moto.servicio.testdatabuilder.MotoTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioCrearMotoTest {

    private static final String LA_MOTO_YA_EXISTE_EN_EL_SISTEMA = "La moto ya existe en el sistema";
    private static final String SE_DEBE_INGRESAR_LA_MATRICULA_DE_LA_MOTO = "Se debe ingresar la matricula de la moto";
    private static final String SE_DEBE_INGRESAR_LA_MARCA_DE_LA_MOTO = "Se debe ingresar la marca de la moto";
    private static final String SE_DEBE_INGRESAR_UNA_MARCA_VALIDA = "Se debe ingresar una marca de moto válida";
    private static final String SE_DEBE_INGRESAR_UN_MODELO_DE_MOTO_VALIDO = "Se debe ingresar un modelo de moto válido";
    private static final String SE_DEBE_INGRESAR_UN_MODELO_DE_MOTO_POSITIVO = "Se debe ingresar un modelo de moto positivo";

    private static final String SE_DEBE_INGRESAR_UN_MODELO_DE_MOTO = "Se debe ingresar un modelo de moto";
    private static final String SE_DEBE_INGRESAR_UN_TIPO_DE_MOTO_VALIDO = "Se debe ingresar un tipo de moto válido";
    private static final String SE_DEBE_INGRESAR_UN_TIPO_DE_MOTO = "Se debe ingresar un tipo de moto";
    private static final String DEBE_INGRESAR_UN_VALOR_POSITIVO_PARA_LOS_KILOMETROS_RECORRIDOS = "Debe ingresar un valor positivo para los kilometros recorridos";
    private static final String DEBE_INGRESAR_UN_VALOR_PARA_LOS_KILOMETROS_RECORRIDOS = "Debe ingresar un valor para los kilometros recorridos";
    private static final String DEBE_INGRESAR_UN_VALOR_POSITIVO_PARA_EL_PRECIO_DE_ALQUILER = "Debe ingresar un valor positivo para el precio de alquiler";
    private static final String DEBE_INGRESAR_UN_VALOR_PARA_EL_PRECIO_DE_ALQUILER = "Debe ingresar un valor para el precio de alquiler";


    @Mock
    private RepositorioMoto repositorioMoto;

    @InjectMocks
    private ServicioCrearMoto servicioCrearMoto;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExcepcionMotoConExistenciaPreviaTest() {
        // arrange
        Moto moto = new MotoTestDataBuilder().build();
        Mockito.when(repositorioMoto.existePorMatriculaExcluyendoId(moto.getMatricula(), moto.getId())).thenReturn(true);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearMoto.ejecutar(moto), ExcepcionDuplicidad.class, LA_MOTO_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarObligatoriaMatriculaMotoTest() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conMatricula(null);
        // act - assert
        BasePrueba.assertThrows(() -> motoTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_MATRICULA_DE_LA_MOTO);
    }

    @Test
    public void validarLongitudMatriculaMotoTest() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conMatricula("");
        // act - assert
        BasePrueba.assertThrows(() -> motoTestDataBuilder.build(), ExcepcionLongitudValor.class, SE_DEBE_INGRESAR_LA_MATRICULA_DE_LA_MOTO);
    }


    @Test
    public void validarObligatorioMarcaMotoTest() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conMarca(null);
        // act - assert
        BasePrueba.assertThrows(() -> motoTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_LA_MARCA_DE_LA_MOTO);
    }

    @Test
    public void validarLongitudMarcaMotoTest() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conMarca("");
        // act - assert
        BasePrueba.assertThrows(() -> motoTestDataBuilder.build(), ExcepcionLongitudValor.class, SE_DEBE_INGRESAR_LA_MARCA_DE_LA_MOTO);
    }

    @Test
    public void validarMarcaMotoTest() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conMarca("KMT");
        // act - assert
        BasePrueba.assertThrows(() -> motoTestDataBuilder.build(), ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_UNA_MARCA_VALIDA);
    }


    @Test
    public void validarObligatorioModeloMotoTest() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conModelo(null);
        // act - assert
        BasePrueba.assertThrows(() -> motoTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UN_MODELO_DE_MOTO);
    }

    @Test
    public void validarModeloMotoMayorACeroTest() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conModelo(-1);
        // act - assert
        BasePrueba.assertThrows(() -> motoTestDataBuilder.build(), ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_UN_MODELO_DE_MOTO_POSITIVO);
    }

    @Test
    public void validarObligatorioTipoMotoTest() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conTipoMoto(null);
        // act - assert
        BasePrueba.assertThrows(() -> motoTestDataBuilder.build(), ExcepcionValorObligatorio.class, SE_DEBE_INGRESAR_UN_TIPO_DE_MOTO);
    }

    @Test
    public void validarLongitudTipoMotoTest() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conTipoMoto("");
        // act - assert
        BasePrueba.assertThrows(() -> motoTestDataBuilder.build(), ExcepcionLongitudValor.class, SE_DEBE_INGRESAR_UN_TIPO_DE_MOTO);
    }

    @Test
    public void validarTipoDeMotoTest() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conTipoMoto("BIKE");
        // act - assert
        BasePrueba.assertThrows(() -> motoTestDataBuilder.build(), ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_UN_TIPO_DE_MOTO_VALIDO);
    }

    @Test
    public void validarObligatorioKilometrosRecorridosMotoTest() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conKilometrosRecorridos(null);
        // act - assert
        BasePrueba.assertThrows(() -> motoTestDataBuilder.build(), ExcepcionValorObligatorio.class, DEBE_INGRESAR_UN_VALOR_PARA_LOS_KILOMETROS_RECORRIDOS);
    }

    @Test
    public void validarKilometrosRecorridosMotoMayorACeroTest() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conKilometrosRecorridos(-1);
        // act - assert
        BasePrueba.assertThrows(() -> motoTestDataBuilder.build(), ExcepcionValorInvalido.class, DEBE_INGRESAR_UN_VALOR_POSITIVO_PARA_LOS_KILOMETROS_RECORRIDOS);
    }

    @Test
    public void validarObligatorioPrecioAlquilerMotoTest() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conPrecioAlquiler(null);
        // act - assert
        BasePrueba.assertThrows(() -> motoTestDataBuilder.build(), ExcepcionValorObligatorio.class, DEBE_INGRESAR_UN_VALOR_PARA_EL_PRECIO_DE_ALQUILER);
    }

    @Test
    public void validarPrecioAlquilerMotoMayorACeroTest() {
        // arrange
        MotoTestDataBuilder motoTestDataBuilder = new MotoTestDataBuilder().conPrecioAlquiler(-1D);
        // act - assert
        BasePrueba.assertThrows(() -> motoTestDataBuilder.build(), ExcepcionValorInvalido.class, DEBE_INGRESAR_UN_VALOR_POSITIVO_PARA_EL_PRECIO_DE_ALQUILER);
    }

    @Test
    public void validarCreacionMotoTest() {
        // arrange
        Moto moto = new MotoTestDataBuilder().
                conId(1L).
                build();
        Mockito.when(repositorioMoto.existePorMatriculaExcluyendoId(moto.getMatricula(), moto.getId())).thenReturn(false);
        Mockito.when(repositorioMoto.crear(moto)).thenReturn(1L);

        // act
        Long idMoto = servicioCrearMoto.ejecutar(moto);

        // assert
        BasePrueba.assertEqualsObject(moto.getId(), idMoto);
    }
}
