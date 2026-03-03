import java.util.Scanner;

public class Teste11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 2) {
            System.out.println("\nEscolha uma opcao:");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Sair");

            opcao = sc.nextInt();
            sc.nextLine(); // limpa buffer
            if (opcao == 1) {
                System.out.println("Digite o nome da conta:");
                String nome = sc.nextLine();
                System.out.println("Digite o saldo:");
                double saldo = sc.nextDouble();
                System.out.println("Digite o número da conta:");
                int numero = sc.nextInt();
                sc.nextLine();

                Conta c1 = new Conta(nome, saldo, numero);

                System.out.println("Conta criada com sucesso!");
                System.out.println("Saldo atual: " + c1.verSaldo());
            }

            else if (opcao == 2) {
                System.out.println("Saindo...");
            }

            else {
                System.out.println("Opção inválida!");
            }
        }
    }
}