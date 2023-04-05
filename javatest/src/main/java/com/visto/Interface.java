package com.visto;

public class Interface {
    public static void showLinha(){
        System.out.println("====================================================================================");
    }
    public static void showMaiorPeso(String nome, String sobrenome, double peso) {
        showLinha();
        System.out.println(" Pessoa com maior peso: " + nome + " " + sobrenome + " com " + peso + "kg");
        showLinha();
    }

    public static void showMaiorAltura(String nome, String sobrenome, double peso) {
        showLinha();
        System.out.println(" Pessoa com maior altura: " + nome + " " + sobrenome + " com " + peso + "cm");
        showLinha();
    }

    public static void showObesidade(){
	System.out.println("Pessoas Obesas:");
    }

    public static void showPessoasObesas(String nome, String sobrenome) {
        System.out.print(" | " + nome + " " + sobrenome);
    }

    public static void formatacao(){
       System.out.println(" ");
    }

    public static void showCartaoPessoa(String nome, String sobreNome, String funcao, String empresa, String veiculo, double peso, double altura, String marcaVeiculo ){
        showLinha();
        System.out.println(" Nome: " + nome + " " + sobreNome);
        System.out.println(" Função: " + funcao);
        System.out.println(" Empresa: " + empresa);
        System.out.println(" Veículo: " + veiculo);
        System.out.println(" Peso: " + peso + "kg");
        System.out.println(" Altura: " + altura + "M");
        System.out.println(" Marca do veículo: " + marcaVeiculo);
        Operador.calcImc(nome, peso, altura);
        showLinha();
    }

    public static void showMarcaMaisUtilizada(String marca, long quantidade){
        showLinha();
        System.out.println(" Marca de veículo mais utilizada: " + marca + " com " + quantidade + " veículos");
        showLinha();
    }

    public static void showFuncaoMaisEncontrada(String funcao, long quantidade){
        showLinha();
        System.out.println(" Função mais encontrada: " + funcao + " com " + quantidade + " pessoas");
        showLinha();
    }

    public static void showEmpresaComMaisPessoas(String empresa, long quantidade){
        showLinha();
        System.out.println(" Empresa com mais pessoas: " + empresa + " com " + quantidade + " pessoas");
        showLinha();
    }
}