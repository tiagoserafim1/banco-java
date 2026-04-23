import java.util.ArrayList;
import java.util.Scanner;

public class MenuBanco {
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
            System.out.println("6 - Transferir");
            System.out.println("7 - Extrato da conta");
            opcao = sc.nextInt();
            sc.nextLine();// limpa buffer

            if (opcao == 1) {
                System.out.println("Digite o nome da conta:");
                String nome = sc.nextLine();
                System.out.println("Digite o saldo:");
                double saldo = sc.nextDouble();
                System.out.println("Digite o número da conta:");
                int numero = sc.nextInt();
                if (buscarConta(contas, numero) != null) {
                    System.out.println("já existe uma conta com esse número. Tente novamente.");
                    continue;
                }
                System.out.println("Digite a senha da conta:");
                int senha = sc.nextInt();

                Conta novaConta = new Conta(nome, saldo, numero, senha);
                contas.add(novaConta);
                System.out.println("Conta criada com sucesso!");

            } else if (opcao == 3) {
                System.out.println("Digite o número da conta:");
                int numeroBuscado = sc.nextInt();
                Conta contaEncontrada = autenticarConta(contas, numeroBuscado, sc);

                if (contaEncontrada != null) {
                    System.out.println(contaEncontrada);
                } else {
                    System.out.println("Acesso negado.");
                }
            } else if (opcao == 4) {
                System.out.println("Digite o número da conta:");
                int numeroBuscado = sc.nextInt();
                Conta contaEncontrada = autenticarConta(contas, numeroBuscado, sc);

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
                    System.out.println("Acesso negado.");
                }
            } else if (opcao == 5) {
                System.out.println("Digite o número da conta:");
                int numeroBuscado = sc.nextInt();
                Conta contaEncontrada = autenticarConta(contas, numeroBuscado, sc);

                if (contaEncontrada != null) {
                    System.out.println("Digite o valor que deseja depositar:");
                    double valor = sc.nextDouble();
                    contaEncontrada.depositar(valor);

                    System.out.println("Depósito realizado! Seu novo saldo é: " + contaEncontrada.verSaldo());
                } else {
                    System.out.println("Acesso negado.");
                }
            } else if (opcao == 6) {
                System.out.println("Digite o número da conta sua conta:");
                int contaEnvi = sc.nextInt();
                Conta contaEncontrada = autenticarConta(contas, contaEnvi, sc);

                if (contaEncontrada != null) {
                    System.out.println("Digite o número da conta que deseja transferir:");
                    int numeroTransferencia = sc.nextInt();
                    transferirDinheiro(contas, numeroTransferencia, contaEncontrada, sc);
                } else {
                    System.out.println("Acesso negado.");
                }

            } else if (opcao == 7) {
                System.out.println("Digite o número da conta:");
                int numeroBuscado = sc.nextInt();
                Conta contaEncontrada = autenticarConta(contas, numeroBuscado, sc);
                if (contaEncontrada != null) {
                    contaEncontrada.mostrarExtrato();
                }
            }
            else {
                System.out.println("Opção inválida!");
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

    public static Conta autenticarConta(ArrayList<Conta> contas, int numero, Scanner sc) {
        Conta contaEncontrada = buscarConta(contas, numero);
        if (contaEncontrada != null) {
            int tentativas = 3;
            while (tentativas > 0) {
                System.out.println("Digite a senha:");
                int senhaDigitada = sc.nextInt();
                if (contaEncontrada.verificarSenha(senhaDigitada)) {
                    System.out.println("Bem vindo, " + contaEncontrada.getNome());
                    return contaEncontrada;
                } else {
                    tentativas--;
                    System.out.println("Senha incorreta. Tentativas restantes: " + tentativas);
                }
            }
                System.out.println("Conta bloqueada!");
            }
        return null;
    }

    public static void transferirDinheiro(ArrayList<Conta> contas, int numeroBuscado, Conta contaEnvia, Scanner sc) {
        Conta contaRecebe = buscarConta(contas, numeroBuscado);
        if (contaRecebe != null) {
            System.out.println("Digite o valor que deseja transferir para:" + contaRecebe.getNome());
            double valorTransferencia = sc.nextDouble();
            if (contaEnvia.transferirPara(contaRecebe, valorTransferencia)) {
                System.out.println("Transferencia realizada com sucesso! O novo saldo é: " + contaEnvia.verSaldo());
            }
        } else {
            System.out.println("Conta destino não encontrada");
        }
    }
}