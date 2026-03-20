import java.util.ArrayList;
import java.util.Scanner;

public class menuBanco {
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
                System.out.println("Digite a senha da conta:");
                int senha = sc.nextInt();

                Conta novaConta = new Conta(nome, saldo, numero, senha);
                contas.add(novaConta);
                System.out.println("Conta criada com sucesso!");
            } else if (opcao == 3) {
                System.out.println("Digite o número da conta:");
                int numeroBuscado = sc.nextInt();
                System.out.println("Digite a senha da conta:");
                int senhaDigitada = sc.nextInt();

                Conta contaEncontrada = autenticarConta(contas, numeroBuscado, senhaDigitada);
                if (contaEncontrada != null) {
                    System.out.println(contaEncontrada);
                } else {
                    System.out.println("Conta ou senha incorreta");
                }
            } else if (opcao == 4) {
                System.out.println("Digite o número da conta:");
                int numeroBuscado = sc.nextInt();
                System.out.println("Digite a senha da conta:");
                int senhaDigitada = sc.nextInt();

                Conta contaEncontrada = autenticarConta(contas, numeroBuscado, senhaDigitada);
                if (contaEncontrada != null) {
                    System.out.println("Digite o valor que deseja sacar:");
                    double valor = sc.nextDouble();

                    if (valor > contaEncontrada.verSaldo()) {
                        System.out.println("Saldo insuficiente");
                    } else {
                        contaEncontrada.sacar(valor);
                        System.out.println("Saque realizado! o novo saldo é: " + contaEncontrada.verSaldo());
                    }
                } else {
                    System.out.println("Conta ou senha incorreta");
                }
            } else if (opcao == 5) {
                System.out.println("Digite o número da conta:");
                int numeroBuscado = sc.nextInt();
                Conta contaEncontrada = buscarConta(contas, numeroBuscado);

                if (contaEncontrada != null) {
                    System.out.println("Digite o valor que deseja depositar:");
                    double valor = sc.nextDouble();
                    contaEncontrada.depositar(valor);

                    System.out.println("Depósito realizado!");
                } else {
                    System.out.println("Conta não encontrada");
                }
            } else {
                System.out.println("Opção invalida");
            }
        }
        sc.close();
    }
    public static Conta buscarConta(ArrayList<Conta> contas, int numeroBuscado) {
        Conta contaEncontrada = null;
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroBuscado) {
                contaEncontrada = conta;
                break;
            }
        }
        return contaEncontrada;
    }
    public static Conta autenticarConta(ArrayList<Conta> contas, int numero, int senha) {
        Conta contaEncontrada = buscarConta(contas, numero);
        if (contaEncontrada != null) {
            if (contaEncontrada.verificarSenha(senha)) {
                return contaEncontrada;
            }
        }
        return null;
    }
}
