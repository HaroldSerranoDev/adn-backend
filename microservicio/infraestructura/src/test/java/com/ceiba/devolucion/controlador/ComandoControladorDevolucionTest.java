package com.ceiba.devolucion.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.devolucion.comando.ComandoDevolucion;
import com.ceiba.devolucion.testdatabuilder.ComandoDevolucionTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorDevolucion.class)
public class ComandoControladorDevolucionTest {

    private static final Long IDENTIFICADOR_ALQUILER_CREACION = 3L;


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception {
        // arrange
        ComandoDevolucion devolucion = new ComandoDevolucionTestDataBuilder().
                conIdAlquiler(IDENTIFICADOR_ALQUILER_CREACION).
                build();

        // act - assert
        mocMvc.perform(
                post("/devoluciones")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(devolucion)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }
}
