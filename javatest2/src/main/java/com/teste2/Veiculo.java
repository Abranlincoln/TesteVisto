package com.teste2;

import com.opencsv.bean.CsvBindByName;

public class Veiculo {
    @CsvBindByName(column = "Veiculo")
    private String veiculoInfo;

    private String ano;
    private String marca;
    private String modelo;

    public Veiculo() {
    }

    public Veiculo(String veiculoInfo) {
        this.veiculoInfo = veiculoInfo;
        String[] partes = veiculoInfo.split(" ");
        if (partes.length >= 3) {
            this.ano = partes[0];
            this.marca = partes[1];
            this.modelo = partes[2];
        }
    }

    @Override
    public String toString() {
        return "Veiculo [ano=" + ano + ", marca=" + marca + ", modelo=" + modelo + "]";
    }

    public String getVeiculoInfo() {
        return veiculoInfo;
    }

    public void setVeiculoInfo(String veiculoInfo) {
        this.veiculoInfo = veiculoInfo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}