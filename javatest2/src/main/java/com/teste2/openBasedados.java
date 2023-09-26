package com.teste2;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;

public class openBasedados {
    public static void main(String[] args) throws IOException {
        String csvFile = "C:\\Users\\abran\\Documents\\GitHub\\front\\TesteVisto\\javatest2\\src\\main\\java\\com\\teste2\\baseDados.csv";
        // Carregar os dados do CSV em listas de objetos Pessoa e Veiculo
        List<Pessoas> pessoas = new CsvToBeanBuilder<Pessoas>(new FileReader(csvFile))
                .withSeparator(';') // Defina o separador como ';'
                .withType(Pessoas.class)
                .build()
                .parse();
        List<Veiculo> veiculos = new CsvToBeanBuilder<Veiculo>(new FileReader(csvFile))
                .withSeparator(';') // Defina o separador como ';'
                .withType(Veiculo.class)
                .build()
                .parse();
        List<Empresa> empresas = new CsvToBeanBuilder<Empresa>(new FileReader(csvFile))
                .withSeparator(';') // Defina o separador como ';'
                .withType(Empresa.class)
                .build()
                .parse();

        // Criar uma instância da classe Estatisticas
        Estatisticas estatisticas = new Estatisticas();

        // Imprimir as estatísticas no console
        estatisticas.imprimirEstatisticas(pessoas, veiculos, empresas);

    }
}