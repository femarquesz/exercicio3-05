package exercicio03;

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
                case 1 ->cadastrar();
            }
            
            
            
        } while ( opcao != 5);
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

    public BilheteUnico pesquisar(){
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
