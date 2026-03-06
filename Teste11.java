import java.util.ArrayList;
import java.util.Scanner;

public class Teste11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        ArrayList<Conta> contas = new ArrayList<>();

        while (opcao != 2) {
            System.out.println("\nEscolha uma opcao:");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Sair");
            System.out.println("3 - Exibir informações da conta");
            System.out.println("4 - Sacar");
            System.out.println("5 - Depositar");
            opcao = sc.nextInt();
            sc.nextLine();// limpa buffer

            if (opcao == 1) {
                System.out.println("Digite o nome da conta:");
                String nome = sc.nextLine();
                System.out.println("Digite o saldo:");
                double saldo = sc.nextDouble();
                System.out.println("Digite o número da conta:");
                int numero = sc.nextInt();

                Conta novaConta = new Conta(nome, saldo, numero);
                contas.add(novaConta);
                System.out.println("Conta criada com sucesso!");
            }
            else if (opcao == 3) {
                System.out.println("Digite o número da conta:");
                int numeroBuscado = sc.nextInt();
                Conta contaEncontrada = null;
                for (Conta conta : contas) {
                    if (conta.numeroConta == numeroBuscado) {
                        contaEncontrada = conta;
                        break;
                    }
                }
                if (contaEncontrada != null) {
                    System.out.println(contaEncontrada);
                } else {
                    System.out.println("Conta não encontrada");
                }
            }
            else if (opcao == 4) {
                System.out.println("Digite o número da conta:");
                int numeroBuscado = sc.nextInt();
                Conta contaEncontrada = null;

                for (Conta conta : contas) {
                    if (conta.numeroConta == numeroBuscado) {
                        contaEncontrada = conta;
                        break;
                    }
                }
                if (contaEncontrada != null) {
                    System.out.println("Digite o valor que deseja sacar:");
                    double valor = sc.nextDouble();
                    if (valor > contaEncontrada.verSaldo()) {
                        System.out.println("Saldo insuficiente");
                    } else {
                        contaEncontrada.sacar(valor);
                        System.out.println("Saque realizado!");
                    }
                } else {
                    System.out.println("Conta não encontrada");
                }
            }
            else if (opcao == 5) {
                System.out.println("Digite o número da conta:");
                int numeroBuscado = sc.nextInt();
                Conta contaEncontrada = null;

                for (Conta conta : contas) {
                    if (conta.numeroConta == numeroBuscado) {
                        contaEncontrada = conta;
                        break;
                    }
                }
                if (contaEncontrada != null) {
                    System.out.println("Digite o valor que deseja depositar:");
                    double valor = sc.nextDouble();
                    contaEncontrada.depositar(valor);
                    System.out.println("Depósito realizado!");
                } else {
                    System.out.println("Conta não encontrada");
                }
            }
        }
        sc.close();
    }
}
