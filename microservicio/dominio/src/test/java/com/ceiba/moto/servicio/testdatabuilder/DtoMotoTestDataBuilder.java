package com.ceiba.moto.servicio.testdatabuilder;

import com.ceiba.moto.modelo.dto.DtoMoto;

public class DtoMotoTestDataBuilder {
    private Long id;
    private String matricula;
    private String marca;
    private Integer modelo;
    private String tipoMoto;
    private Integer kilometrosRecorridos;
    private Double precioAlquiler;

    public DtoMotoTestDataBuilder() {
        this.id = 1L;
        this.matricula = "RKL98C";
        this.marca = "HONDA";
        this.modelo = 2021;
        this.tipoMoto = "SPORT";
        this.kilometrosRecorridos = 0;
        this.precioAlquiler = 250000D;
    }

    public DtoMotoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public DtoMotoTestDataBuilder conMatricula(String matricula) {
        this.matricula = matricula;
        return this;
    }

    public DtoMotoTestDataBuilder conMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public DtoMotoTestDataBuilder conModelo(Integer modelo) {
        this.modelo = modelo;
        return this;
    }

    public DtoMotoTestDataBuilder conTipoMoto(String tipoMoto) {
        this.tipoMoto = tipoMoto;
        return this;
    }

    public DtoMotoTestDataBuilder conKilometrosRecorridos(Integer kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
        return this;
    }

    public DtoMotoTestDataBuilder conPrecioAlquiler(Double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
        return this;
    }


    public DtoMoto build() {
        return new DtoMoto(id, matricula, marca, modelo, tipoMoto, kilometrosRecorridos, precioAlquiler);
    }

}
