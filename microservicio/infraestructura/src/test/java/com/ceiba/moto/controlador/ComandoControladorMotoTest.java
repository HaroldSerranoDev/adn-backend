package com.ceiba.moto.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.moto.comando.ComandoMoto;
import com.ceiba.moto.testdatabuilder.ComandoMotoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorMoto.class)
public class ComandoControladorMotoTest {

    private static final String MATRICULA_CREACION = "CAY12R";
    private static final String TIPO_MOTO_ACTUALIZACION = "ENDURO";


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception {
        // arrange
        ComandoMoto moto = new ComandoMotoTestDataBuilder().
                conMatriula(MATRICULA_CREACION).
                build();

        // act - assert
        mocMvc.perform(
                post("/motos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(moto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));
    }

    @Test
    public void actualizar() throws Exception {
        // arrange
        Long id = 2L;
        ComandoMoto moto = new ComandoMotoTestDataBuilder().
                conTipoMoto(TIPO_MOTO_ACTUALIZACION).
                build();

        // act - assert
        mocMvc.perform(put("/motos/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(moto)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 4L;

        // act - assert
        mocMvc.perform(delete("/motos/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
