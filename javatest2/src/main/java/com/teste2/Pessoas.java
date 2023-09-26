package com.teste2;

import com.opencsv.bean.CsvBindByName;

public class Pessoas {

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoas other = (Pessoas) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @CsvBindByName(column = "Nome")
    private String nome;
    @CsvBindByName(column = "Sobrenome")
    private String sobrenome;
    @CsvBindByName(column = "Peso")
    private double peso;
    @CsvBindByName(column = "Altura")
    private double altura;

    @Override
    public String toString() {
        return "Pessoas [nome=" + nome + ", sobrenome=" + sobrenome + ", peso=" + peso + ", altura=" + altura
                + "]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}
