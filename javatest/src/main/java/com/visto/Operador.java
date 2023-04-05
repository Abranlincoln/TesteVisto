package com.visto;

public class Operador {
    public static void calcImc(String nome, double peso, double altura) {
        double calcImc = Math.round(peso / (altura * altura));
        if (calcImc < 18.5) {
            System.out.println(" " + nome + ", Possui: Magreza" + ", IMC: " + calcImc);
        } else if (calcImc >= 18.5 && calcImc <= 24.9) {
            System.out.println(" " + nome + ", Possui: Peso normal" + ", IMC: " + calcImc);
        } else if (calcImc >= 25 && calcImc <= 29.9) {
            System.out.println(" " + nome + ", Possui: Sobrepeso" + ", IMC: " + calcImc);
        } else if (calcImc >= 30 && calcImc <= 39.9) {
            System.out.println(" " + nome + ", Possui: Obesidade" + ", IMC: " + calcImc);
        } else if (calcImc >= 40) {
            System.out.println(" " + nome + ", Possui: Obesidade grave" + ", IMC: " + calcImc);
        }
    }
}