package com.ceiba.alquiler.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.testdatabuilder.ComandoAlquilerTestDataBuilder;
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
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorAlquiler.class)
public class ComandoControladorAlquilerTest {

    private static final String FECHA_ENTREGA_ACTUALIZACION = "2021-03-10";
    private static final Long IDENTIFICADOR_MOTO_CREACION = 3L;


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoAlquiler alquiler = new ComandoAlquilerTestDataBuilder().
                conIdMoto(IDENTIFICADOR_MOTO_CREACION).
                build();

        // act - assert
        mocMvc.perform(
                post("/alquileres")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(alquiler)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 4}"));
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 1L;
        ComandoAlquiler alquiler = new ComandoAlquilerTestDataBuilder().
                conFechaEntrega(FECHA_ENTREGA_ACTUALIZACION).
                build();

        // act - assert
        mocMvc.perform(put("/alquileres/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(alquiler)))
                .andExpect(status().isOk());
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/alquileres/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
