package com.visto;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class CSVLeitor {

        // caminho do arquivo CSV
        private static final String CAMINHO_CSV = "C:\\Users\\abranlincoln\\Desktop\\TesteVisto\\javatest\\src\\main\\java\\com\\visto\\baseDados1.csv";

        public static void main(String[] args) {

                try {

                        // criando o parser para ler o arquivo CSV e depois ler o arquivo
                        CSVParser analisador = new CSVParserBuilder().withSeparator(';').withQuoteChar('"').build();
                        CSVReader csvLeitor = new CSVReaderBuilder(new FileReader(new File(CAMINHO_CSV)))
                                        .withSkipLines(0)
                                        .withCSVParser(analisador)
                                        .build();

                        // criando lista de mapas para armazenar os dados
                        List<Map<String, String>> linhas = new ArrayList<Map<String, String>>();
                        String[] cabecalho = csvLeitor.readNext();
                        String[] colunas = null;

                        while ((colunas = csvLeitor.readNext()) != null) {
                                Map<String, String> campoMap = new HashMap<String, String>();
                                for (int i = 0; i < colunas.length; i++) {
                                        campoMap.put(cabecalho[i], colunas[i]);
                                }
                                linhas.add(campoMap);
                        }

                        // imprimir todos os dados de forma organizada
                        linhas.forEach(coluna -> {

                                String marca = coluna.get("Veículo").split(" ")[1];
                                double altura = Double.parseDouble(coluna.get("Altura")) / 100;
                                double peso = Double.parseDouble(coluna.get("Peso"));

                                Interface.showCartaoPessoa(coluna.get("Nome"), coluna.get("Sobrenome"),
                                                coluna.get("Função"),
                                                coluna.get("Empresa"), coluna.get("Veículo"), peso, altura, marca);

                        });

                        // Pessoa com maior peso
                        linhas.stream().max(
                                        (pesoInicio, pesoFim) -> Double.compare(
                                                        Double.parseDouble(pesoInicio.get("Peso")),
                                                        Double.parseDouble(pesoFim.get("Peso"))))
                                        .ifPresent(posicao -> Interface.showMaiorPeso(posicao.get("Nome"),
                                                        posicao.get("Sobrenome"),
                                                        Double.parseDouble(posicao.get("Peso"))));

                        // Pessoa com maior altura
                        linhas.stream().max((alturaInicio, alturaFim) -> Double.compare(
                                        Double.parseDouble(alturaInicio.get("Altura")),
                                        Double.parseDouble(alturaFim.get("Altura"))))
                                        .ifPresent(posicao -> Interface.showMaiorAltura(posicao.get("Nome"),
                                                        posicao.get("Sobrenome"),
                                                        Double.parseDouble(posicao.get("Altura"))));

                        // Calcular IMC e separar as pessoas obesas se houver
			Interface.showObesidade();
                        linhas.stream().filter(posicao -> {
                                double alturaIMC = Double.parseDouble(posicao.get("Altura")) / 100;
                                double pesoIMC = Double.parseDouble(posicao.get("Peso"));
                                double imcEspecifico = pesoIMC / (alturaIMC * alturaIMC);
                                return imcEspecifico >= 30;
                        }).forEach(posicao -> Interface.showPessoasObesas(posicao.get("Nome"),
                                        posicao.get("Sobrenome")));
			Interface.formatacao();
			

                        // Marca de veículo mais utilizada + quantidade
                        linhas.stream()
                                        .collect(Collectors.groupingBy(
                                                        posicao -> posicao.get("Veículo").split(" ")[1],
                                                        Collectors.counting()))
                                        .entrySet().stream()
                                        .max((marcaInit, marcaFinal) -> Long.compare(marcaInit.getValue(),
                                                        marcaFinal.getValue()))
                                        .ifPresent(posicao -> Interface.showMarcaMaisUtilizada(posicao.getKey(),
                                                        posicao.getValue()));

                        // Função mais encontrada + quantidade
                        linhas.stream().collect(
                                        Collectors.groupingBy(posicao -> posicao.get("Função"), Collectors.counting()))
                                        .entrySet()
                                        .stream()
                                        .max((functionInit, functionFinal) -> Long
                                                        .compare(functionInit.getValue(), functionFinal.getValue()))
                                        .ifPresent(posicao -> Interface.showFuncaoMaisEncontrada(posicao.getKey(),
                                                        posicao.getValue()));

                        // Empresa com mais pessoas + quantidade
                        linhas.stream()
                                        .collect(Collectors.groupingBy(posicao -> posicao.get("Empresa"),
                                                        Collectors.counting()))
                                        .entrySet().stream()
                                        .max((empresaInit, empresaFinal) -> Long.compare(empresaInit.getValue(),
                                                        empresaFinal.getValue()))
                                        .ifPresent(posicao -> Interface.showEmpresaComMaisPessoas(posicao.getKey(),
                                        posicao.getValue()));
                        csvLeitor.close();
                } catch (Exception erro) {
                        System.out.println("Erro: " + erro.getMessage());
                }
        }
}