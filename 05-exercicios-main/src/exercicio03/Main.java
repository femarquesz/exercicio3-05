package exercicio03;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static BilheteUnico[] bilhete = new BilheteUnico[10];
    static Scanner sc = new Scanner(System.in);
    static int index;
    
    
    public static void main(String[] args) {
        int opcao;
        
        do {
            //CTRL + D PARA DUPLICAR LINHA
            System.out.println("[1] Cadastrar bilhete");
            System.out.println("[2] Carregar bilhete");
            System.out.println("[3] Consultar saldo");
            System.out.println("[4] Passar na catraca");
            System.out.println("[5] Finalizar");
            opcao = sc.nextInt();
            
            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> carregar();
                case 3 -> consultarSaldo();
                case 4 -> passarCatraca();
                case 5 -> System.out.println("Finalizado!");
                default -> System.out.println("Opção inválida!");
            }
            System.out.println("\n#######################################################");
        } while ( opcao != 5);
    }

    private static void passarCatraca() {
        BilheteUnico bilheteUnico = pesquisar();
        if (bilheteUnico != null) {
            if (!bilheteUnico.passarNaCatraca()) {
                System.out.println("Saldo insuficiente");
            }
            System.out.println("Saldo atual R$ " + bilheteUnico.saldo);
        }
    }

    private static void consultarSaldo() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        BilheteUnico bilheteUnico = pesquisar();
        if (bilheteUnico != null) {
            System.out.println("Saldo atual R$ " + df.format(bilheteUnico.saldo));
            //USANDO O "." PARA ACESSAR O ATRIBUTO "SALDO"
        }
    }

    private static void carregar() {
        double valor;
        BilheteUnico bilheteUnico = pesquisar();
        //IF PARA CARREGAR SÓ SE TIVER UM BILHETE UNICO
        if (bilheteUnico != null) {
            System.out.println("Valor da recarga: ");
            valor = sc.nextDouble();
            bilheteUnico.carregar(valor);
        }
    }

    private static void cadastrar() {
        String nome;
        long cpf;
        String tipoTarifa;

        if (index < bilhete.length) {
            System.out.println("Nome do usuário: ");
            nome = sc.next();
            System.out.println("CPF: ");
            cpf = sc.nextLong();
            System.out.println("Tipo de tarifa (ESTUDANTE / PROFESSOR / COMUM): ");
            tipoTarifa = sc.next();
            bilhete[index] = new BilheteUnico(new Usuario(nome, cpf, tipoTarifa));
            index++;
        }
        else {
            System.out.println("Erro ao gerar o bilhete!");
        }

    }

    public static BilheteUnico pesquisar(){
        long cpf;
        System.out.println("Qual o CPF para pesquisa? ");
        cpf = sc.nextLong();
        for (int i = 0; i < index; i++) {
            if (bilhete[i].usuario.cpf==cpf) {
                return bilhete[i];
            }
        }
        System.out.println("CPF nao encontrado");
        return null;
    }
}
