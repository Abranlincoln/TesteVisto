package com.visto;

//Classe destinada a calcular o IMC individualmente.
public class Operador {
    public static void calcImc(double peso, double altura) {
        double calcImc = Math.round(peso / (altura * altura));
        if (calcImc < 18.5) {
            System.out.println(" Possui: Magreza" + ", IMC: " + calcImc);
        } else if (calcImc >= 18.5 && calcImc <= 24.9) {
            System.out.println(" Possui: Peso Normal" + ", IMC: " + calcImc);
        } else if (calcImc >= 25 && calcImc <= 29.9) {
            System.out.println(" Possui: Sobrepeso" + ", IMC: " + calcImc);
        } else if (calcImc >= 30 && calcImc <= 39.9) {
            System.out.println(" Possui: Obesidade" + ", IMC: " + calcImc);
        } else if (calcImc >= 40) {
            System.out.println(" Possui: Obesidade Grave" + ", IMC: " + calcImc);
        }
    }
}