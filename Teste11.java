import java.util.Scanner;

public class Teste11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome:");
        String nome = sc.nextLine();

        System.out.println("Digite o saldo:");
        double saldo = sc.nextDouble();

        System.out.println("Digite o número:");
        int numero = sc.nextInt();

        Conta c1 = new Conta(nome, saldo, numero);
    }
}