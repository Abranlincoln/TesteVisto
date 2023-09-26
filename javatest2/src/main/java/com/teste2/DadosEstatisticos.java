package com.teste2;

import java.util.List;

public interface DadosEstatisticos {

    // Método para obter a marca de veículo mais utilizada
    String marcaMaisUtilizada(List<Veiculo> veiculos);
    
    // Método para calcular o IMC médio das pessoas
    double calcularIMCMedio(List<Pessoas> pessoas);

    // Método para encontrar a pessoa mais gorda
    Pessoas pessoaMaisGorda(List<Pessoas> pessoas);

    // Método para encontrar a pessoa mais alta
    Pessoas pessoaMaisAlta(List<Pessoas> pessoas);

    // Método para encontrar a pessoa mais magra
    Pessoas pessoaMaisMagra(List<Pessoas> pessoas);

    
    // Método para imprimrie a empresa com mais funcionarios
    Empresa EmpresaComMaisFuncionarios(List<Empresa> empresas);

    // Método para imprimir as estatísticas
    void imprimirEstatisticas(List<Pessoas> pessoas, List<Veiculo> veiculos, List<Empresa> empresas);

}