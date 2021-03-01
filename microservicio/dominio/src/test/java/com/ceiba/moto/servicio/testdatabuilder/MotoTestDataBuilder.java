package com.ceiba.moto.servicio.testdatabuilder;

import com.ceiba.moto.modelo.entidad.Marca;
import com.ceiba.moto.modelo.entidad.Moto;
import com.ceiba.moto.modelo.entidad.TipoMoto;

public class MotoTestDataBuilder {

    private Long id;
    private String matricula;
    private String marca;
    private Integer modelo;
    private String tipoMoto;
    private Integer kilometrosRecorridos;
    private Double precioAlquiler;

    public MotoTestDataBuilder() {
        this.id = 0L;
        this.matricula = "RKL98C";
        this.marca = "HONDA";
        this.modelo = 2021;
        this.tipoMoto = "SPORT";
        this.kilometrosRecorridos = 0;
        this.precioAlquiler = 250000D;
    }

    public MotoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public MotoTestDataBuilder conMatricula(String matricula) {
        this.matricula = matricula;
        return this;
    }

    public MotoTestDataBuilder conMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public MotoTestDataBuilder conModelo(Integer modelo) {
        this.modelo = modelo;
        return this;
    }

    public MotoTestDataBuilder conTipoMoto(String tipoMoto) {
        this.tipoMoto = tipoMoto;
        return this;
    }

    public MotoTestDataBuilder conKilometrosRecorridos(Integer kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
        return this;
    }

    public MotoTestDataBuilder conPrecioAlquiler(Double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
        return this;
    }


    public Moto build() {
        return new Moto(id,matricula,marca,modelo,tipoMoto,kilometrosRecorridos,precioAlquiler);
    }
}
