package com.teste2;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Estatisticas implements DadosEstatisticos {

    @Override
    public String marcaMaisUtilizada(List<Veiculo> veiculos) {
        // Filtrar veículos com marca não nula
        List<Veiculo> veiculosComMarca = veiculos.stream()
                .filter(veiculo -> veiculo.getMarca() != null)
                .collect(Collectors.toList());

        // Verificar se há veículos com marca
        if (veiculosComMarca.isEmpty()) {
            return "Nenhuma marca disponível"; // Ou outra mensagem apropriada
        }

        // Agrupar veículos por marca e contar a frequência de cada marca
        Map<String, Long> contagemPorMarca = veiculosComMarca.stream()
                .collect(Collectors.groupingBy(Veiculo::getMarca, Collectors.counting()));

        // Encontrar a marca com a contagem mais alta
        Optional<Map.Entry<String, Long>> marcaMaisUtilizada = contagemPorMarca.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        // Verificar se há uma marca mais utilizada
        if (marcaMaisUtilizada.isPresent()) {
            return marcaMaisUtilizada.get().getKey(); // Retorna a marca mais utilizada
        } else {
            return "Nenhuma marca disponível"; // Ou outra mensagem apropriada
        }
    }

    @Override
    public double calcularIMCMedio(List<Pessoas> pessoas) {
        if (pessoas.isEmpty()) {
            return 0.0; // Evite a divisão por zero se a lista estiver vazia
        }

        double somaIMC = 0.0;

        for (Pessoas pessoa : pessoas) {
            double alturaEmMetros = pessoa.getAltura() / 100.0; // Converter altura de cm para m
            double imc = pessoa.getPeso() / (alturaEmMetros * alturaEmMetros);
            somaIMC += imc;
        }

        double imcMedio = somaIMC / pessoas.size();
        return imcMedio;
    }

    @Override
    public Pessoas pessoaMaisGorda(List<Pessoas> pessoas) {
        Pessoas pessoaMaisGorda = null;
        double maiorPeso = Double.MIN_VALUE;

        for (Pessoas pessoa : pessoas) {
            if (pessoa.getPeso() > maiorPeso) {
                maiorPeso = pessoa.getPeso();
                pessoaMaisGorda = pessoa;
            }
        }

        return pessoaMaisGorda;
    }

    @Override
    public Pessoas pessoaMaisAlta(List<Pessoas> pessoas) {
        if (pessoas.isEmpty()) {
            return null; // Retorna null se a lista estiver vazia
        }

        Pessoas pessoaMaisAlta = pessoas.get(0); // Inicialmente, assumimos que a primeira pessoa é a mais alta

        for (Pessoas pessoa : pessoas) {
            if (pessoa.getAltura() > pessoaMaisAlta.getAltura()) {
                pessoaMaisAlta = pessoa; // Atualiza a pessoa mais alta se encontrarmos alguém mais alto
            }
        }

        return pessoaMaisAlta;
    }

    @Override
    public Pessoas pessoaMaisMagra(List<Pessoas> pessoas) {
        if (pessoas.isEmpty()) {
            return null; // Retorna null se a lista estiver vazia
        }

        Pessoas pessoaMaisMagra = pessoas.get(0); // Inicialmente, assumimos que a primeira pessoa é a mais magra

        for (Pessoas pessoa : pessoas) {
            if (pessoa.getPeso() < pessoaMaisMagra.getPeso()) {
                pessoaMaisMagra = pessoa; // Atualiza a pessoa mais magra se encontrarmos alguém mais magro
            }
        }

        return pessoaMaisMagra;
    }
    
    @Override
    public Empresa EmpresaComMaisFuncionarios(List<Empresa> empresas) {
        Empresa empresaComMaisFuncionarios = null;
        int maxFuncionarios = 0;
    
        for (Empresa empresa : empresas) {
            List<Funcao> funcoes = empresa.getFuncoes();
            int numeroFuncionarios = funcoes.size();
    
            if (numeroFuncionarios > maxFuncionarios) {
                maxFuncionarios = numeroFuncionarios;
                empresaComMaisFuncionarios = empresa;
            }
        }
        
        return empresaComMaisFuncionarios;
    }
    
    @Override
    public void imprimirEstatisticas(List<Pessoas> pessoas, List<Veiculo> veiculos, List<Empresa> empresas) {
        // Chame os métodos acima para calcular as estatísticas
        String marcaMaisUtilizada = marcaMaisUtilizada(veiculos);
        Pessoas pessoaMaisGorda = pessoaMaisGorda(pessoas);
        double imcMedio = calcularIMCMedio(pessoas);
        Pessoas pessoaMaisAlta = pessoaMaisAlta(pessoas);
        Pessoas pessoaMaisMagra = pessoaMaisMagra(pessoas);
        Empresa empresaComMaisFuncionarios = EmpresaComMaisFuncionarios(empresas);

        // Imprima as estatísticas no console
        System.out.println("Marca mais utilizada: " + marcaMaisUtilizada);
        System.out.println("Pessoa mais gorda: " + pessoaMaisGorda);
        System.out.println("IMC médio das pessoas: " + imcMedio);
        System.out.println("Pessoa mais alta: " + pessoaMaisAlta);
        System.out.println("Pessoa mais magra: " + pessoaMaisMagra);
        System.out.println("Empresa com mais funcionários: " + empresaComMaisFuncionarios);
    }

}
