package com.ceiba.moto.comando.fabrica;

import com.ceiba.moto.comando.ComandoMoto;
import com.ceiba.moto.modelo.entidad.Moto;
import org.springframework.stereotype.Component;

@Component
public class FabricaMoto {

    public Moto crear(ComandoMoto comandoMoto) {
        return new Moto(
                comandoMoto.getId(),
                comandoMoto.getMatricula(),
                comandoMoto.getMarca(),
                comandoMoto.getModelo(),
                comandoMoto.getTipoMoto(),
                comandoMoto.getKilometrosRecorridos(),
                comandoMoto.getPrecioAlquiler()
        );
    }

}
