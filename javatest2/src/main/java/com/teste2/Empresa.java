package com.teste2;

import java.util.List;
import com.opencsv.bean.CsvBindByName;

public class Empresa {
    @CsvBindByName(column = "Empresa")
    private String nomeEmpresa;
    @CsvBindByName(column = "Funcao")
    private List<Funcao> funcao;

    // Construtores, getters e setters
    public String getEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresaString(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public List<Funcao> getFuncoes() {
        return funcao;
    }

    public void setFuncoes(List<Funcao> funcao) {
        this.funcao = funcao;
    }
}
