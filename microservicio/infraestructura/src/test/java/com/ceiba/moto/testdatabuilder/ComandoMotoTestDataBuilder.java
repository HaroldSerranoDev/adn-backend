package com.ceiba.moto.testdatabuilder;

import com.ceiba.moto.comando.ComandoMoto;

public class ComandoMotoTestDataBuilder {

    private Long id;
    private String matricula;
    private String marca;
    private Integer modelo;
    private String tipoMoto;
    private Integer kilometrosRecorridos;
    private Double precioAlquiler;


    public ComandoMotoTestDataBuilder() {
        this.id = 0L;
        this.matricula = "FGH65L";
        this.marca = "SUZUKI";
        this.modelo = 2020;
        this.tipoMoto = "SPORT";
        this.kilometrosRecorridos = 0;
        this.precioAlquiler = 200000D;
    }

    public ComandoMotoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoMotoTestDataBuilder conMatriula(String matricula) {
        this.matricula = matricula;
        return this;
    }

    public ComandoMotoTestDataBuilder conMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public ComandoMotoTestDataBuilder conModelo(int modelo) {
        this.modelo = modelo;
        return this;
    }

    public ComandoMotoTestDataBuilder conTipoMoto(String tipoMoto) {
        this.tipoMoto = tipoMoto;
        return this;
    }

    public ComandoMotoTestDataBuilder conPrecioAlquiler(Double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
        return this;
    }


    public ComandoMoto build() {
        return new ComandoMoto(id, matricula, marca, modelo, tipoMoto, kilometrosRecorridos, precioAlquiler);
    }
}
