package com.teste2;

import com.opencsv.bean.CsvBindByName;

public class Funcao {
    @CsvBindByName(column = "Funcao")
    private String funcao;

    @Override
    public String toString() {
        return "Funcao [funcao=" + funcao + "]";
    }

    // Construtores, getters e setters
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}