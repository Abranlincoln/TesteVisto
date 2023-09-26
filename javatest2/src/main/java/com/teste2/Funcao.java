package com.teste2;

import java.util.List;

import com.opencsv.bean.CsvBindByName;

public class Funcao {
    @CsvBindByName(column = "Funcao")
    private List<Funcao> funcao;


    @Override
    public String toString() {
        return "Funcao [funcao=" + funcao + "]";
    }

    // Construtores, getters e setters
    public List<Funcao> getFuncao() {
        return funcao;
    }

    public void setFuncao(List<Funcao> funcao) {
        this.funcao = funcao;
    }
}